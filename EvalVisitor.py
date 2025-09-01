import math
from LabeledExprVisitor import LabeledExprVisitor

class EvalVisitor(LabeledExprVisitor):
    def __init__(self):
        self.memory = {}
        self.useDegrees = True  # Por defecto en grados

    def visitAssign(self, ctx):
        name = ctx.ID().getText()
        value = self.visit(ctx.expr())
        self.memory[name] = value
        return value

    def visitPrintExpr(self, ctx):
        value = self.visit(ctx.expr())
        print(value)
        return value

    def visitInt(self, ctx):
        return float(ctx.getText())

    def visitId(self, ctx):
        return self.memory.get(ctx.getText(), 0.0)

    def visitMulDiv(self, ctx):
        l, r = self.visit(ctx.expr(0)), self.visit(ctx.expr(1))
        return l * r if ctx.op.text == '*' else l / r

    def visitAddSub(self, ctx):
        l, r = self.visit(ctx.expr(0)), self.visit(ctx.expr(1))
        return l + r if ctx.op.text == '+' else l - r

    def visitParens(self, ctx):
        return self.visit(ctx.expr())

    def visitFactorial(self, ctx):
        n = int(self.visit(ctx.expr()))
        return float(math.prod(range(1, n+1))) if n > 0 else 1.0

    def visitFunction(self, ctx):
        func = ctx.func().getText()
        val = self.visit(ctx.expr())

        if self.useDegrees and func in ("sin", "cos", "tan"):
            val = math.radians(val)

        funcs = {
            "sin": math.sin, "cos": math.cos, "tan": math.tan,
            "sqrt": math.sqrt, "ln": math.log, "log": math.log10
        }
        return funcs[func](val)
