import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends LabeledExprBaseVisitor<Double> {
    private Map<String, Double> memory = new HashMap<>();
    private boolean useDegrees = true; 

    public void setUseDegrees(boolean flag) {
        this.useDegrees = flag;
    }

    @Override
    public Double visitAssign(LabeledExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        double value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Double visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
        Double value = visit(ctx.expr());
        System.out.println(value);
        return 0.0;
    }

    @Override
    public Double visitInt(LabeledExprParser.IntContext ctx) {
        return Double.valueOf(ctx.INT().getText());
    }

    @Override
    public Double visitId(LabeledExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) return memory.get(id);
        return 0.0;
    }

    @Override
    public Double visitMulDiv(LabeledExprParser.MulDivContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));
        if (ctx.op.getType() == LabeledExprParser.MUL) return left * right;
        return left / right;
    }

    @Override
    public Double visitAddSub(LabeledExprParser.AddSubContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));
        if (ctx.op.getType() == LabeledExprParser.ADD) return left + right;
        return left - right;
    }

    @Override
    public Double visitParens(LabeledExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Double visitFactorial(LabeledExprParser.FactorialContext ctx) {
        double value = visit(ctx.expr());
        if (value != Math.floor(value) || value < 0) {
            throw new RuntimeException("Factorial solo definido para enteros no negativos");
        }
        return (double) factorial((int) value);
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        int res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    @Override
    public Double visitFunction(LabeledExprParser.FunctionContext ctx) {
        double arg = visit(ctx.expr());

        int funcType = ctx.func().getStart().getType();
        if (useDegrees && (
            funcType == LabeledExprParser.SIN ||
            funcType == LabeledExprParser.COS ||
            funcType == LabeledExprParser.TAN)) {
            arg = Math.toRadians(arg);
        }

        switch (funcType) {
            case LabeledExprParser.SIN:  return Math.sin(arg);
            case LabeledExprParser.COS:  return Math.cos(arg);
            case LabeledExprParser.TAN:  return Math.tan(arg);
            case LabeledExprParser.SQRT: return Math.sqrt(arg);
            case LabeledExprParser.LN:   return Math.log(arg);
            case LabeledExprParser.LOG:  return Math.log10(arg);
            default: throw new RuntimeException("Función desconocida");
        }
    }
}

