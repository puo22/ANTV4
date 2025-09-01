import sys
from antlr4 import *
from LabeledExprLexer import LabeledExprLexer
from LabeledExprParser import LabeledExprParser
from EvalVisitor import EvalVisitor

def main():
    visitor = EvalVisitor()
    print("Calculadora ANTLR4 (Python)")
    print("Escribe 'exit' para salir")
    print("Modo actual: GRADOS")
    print("Comandos: mode=deg | mode=rad")

    while True:
        try:
            line = input("> ")
        except EOFError:
            break

        if line.strip().lower() == "exit":
            break

        if line.strip().lower() == "mode=deg":
            visitor.useDegrees = True
            print("Modo cambiado a GRADOS")
            continue

        if line.strip().lower() == "mode=rad":
            visitor.useDegrees = False
            print("Modo cambiado a RADIANES")
            continue

        input_stream = InputStream(line + "\n")
        lexer = LabeledExprLexer(input_stream)
        tokens = CommonTokenStream(lexer)
        parser = LabeledExprParser(tokens)
        tree = parser.stat()

        visitor.visit(tree)

if __name__ == '__main__':
    main()
