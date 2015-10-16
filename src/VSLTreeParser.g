tree grammar VSLTreeParser;

/* Options */
options {
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
}

/* Axiom */
s [SymbolTable symTab] returns [Code3a code]
  : e=expression[symTab] 
    {
      code = e.code;
    }
;

/* Instructions */
statement [SymbolTable symTab] returns [Code3a code3a]
  : ^(ASSIGN_KW e1=expression[symTab] IDENT 
      (
        {
          code3a = Code3aGenerator.genAssignExpr(symTab, e1, $IDENT.text);
        }
      )
    )

  | b=block[symTab]
      {
        code3a=b;
      }
;

/* Block of code */
block [SymbolTable symTab] returns [Code3a code3a]
  : ^(BLOCK il=inst_list[symTab])
    {
      code3a=il;
    }
;

/* Instruction list */
inst_list [SymbolTable symTab] returns [Code3a code3a]
  : ^(INST(
      il=statement[symTab]
      {
        code3a = il;
      }
    )+)
;

/* Expressions */
expression [SymbolTable symTab] returns [ExpAttribute expAtt]
  : /* Addition operation */ 
    ^(PLUS e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }

  | /* Substraction operation */
    ^(MINUS e1=expression[symTab] e2=expression[symTab])
    {
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }

  | /* Multiplication operation */
    ^(MUL e1=expression[symTab] e2=expression[symTab])
    {
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }

  | /* Division operation */
    ^(DIV e1=expression[symTab] e2=expression[symTab])
    {
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }

  | pe=primary_exp[symTab] 
    { 
      expAtt = pe; 
    }
;

/* Primary expression */
primary_exp [SymbolTable symTab] returns [ExpAttribute expAtt]
  : INTEGER
    {
      ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
    }

  | IDENT
    {
      Operand3a id = symTab.lookup($IDENT.text);
      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
    }
;

/* Declarations */
declaration [SymbolTable symTab] returns [Code3a code3a]
  : ^(DECL value = decl_list[symTab])
    {
      code3a = value;
    }
;

/* List of declararations */
decl_list [SymbolTable symTab] returns [Code3a code3a]
    : (
        (
          value = decl_item[symTab]
          {
            code3a.append(value);
          }
        )+
      )
;

/* The real declaration of one precised variable */
decl_item [SymbolTable symTab] returns [Code3a code3a]
  : IDENT 
  {
    code3a.append(Code3aGenerator.genDeclVar(symTab, $IDENT.text));
  }
;
