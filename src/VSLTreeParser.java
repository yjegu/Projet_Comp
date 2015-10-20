// $ANTLR 3.5 ./src/VSLTreeParser.g 2015-10-20 13:14:49

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class VSLTreeParser extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASCII", "ASSIGN_KW", "COM", "COMMENT", 
		"DIGIT", "DIV", "DO_KW", "ELSE_KW", "FI_KW", "FUNC_KW", "IDENT", "IF_KW", 
		"INTEGER", "INT_KW", "LB", "LC", "LETTER", "LP", "MINUS", "MUL", "OD_KW", 
		"PLUS", "PRINT_KW", "PROTO_KW", "RB", "RC", "READ_KW", "RETURN_KW", "RP", 
		"TEXT", "THEN_KW", "VOID_KW", "WHILE_KW", "WS", "ARDECL", "ARELEM", "ARRAY", 
		"BLOCK", "BODY", "DECL", "FCALL", "FCALL_S", "INST", "NEGAT", "PARAM", 
		"PROG"
	};
	public static final int EOF=-1;
	public static final int ASCII=4;
	public static final int ASSIGN_KW=5;
	public static final int COM=6;
	public static final int COMMENT=7;
	public static final int DIGIT=8;
	public static final int DIV=9;
	public static final int DO_KW=10;
	public static final int ELSE_KW=11;
	public static final int FI_KW=12;
	public static final int FUNC_KW=13;
	public static final int IDENT=14;
	public static final int IF_KW=15;
	public static final int INTEGER=16;
	public static final int INT_KW=17;
	public static final int LB=18;
	public static final int LC=19;
	public static final int LETTER=20;
	public static final int LP=21;
	public static final int MINUS=22;
	public static final int MUL=23;
	public static final int OD_KW=24;
	public static final int PLUS=25;
	public static final int PRINT_KW=26;
	public static final int PROTO_KW=27;
	public static final int RB=28;
	public static final int RC=29;
	public static final int READ_KW=30;
	public static final int RETURN_KW=31;
	public static final int RP=32;
	public static final int TEXT=33;
	public static final int THEN_KW=34;
	public static final int VOID_KW=35;
	public static final int WHILE_KW=36;
	public static final int WS=37;
	public static final int ARDECL=38;
	public static final int ARELEM=39;
	public static final int ARRAY=40;
	public static final int BLOCK=41;
	public static final int BODY=42;
	public static final int DECL=43;
	public static final int FCALL=44;
	public static final int FCALL_S=45;
	public static final int INST=46;
	public static final int NEGAT=47;
	public static final int PARAM=48;
	public static final int PROG=49;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public VSLTreeParser(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public VSLTreeParser(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return VSLTreeParser.tokenNames; }
	@Override public String getGrammarFileName() { return "./src/VSLTreeParser.g"; }



	// $ANTLR start "s"
	// ./src/VSLTreeParser.g:11:1: s[SymbolTable symTab] returns [Code3a code] : st= statement[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a st =null;

		try {
			// ./src/VSLTreeParser.g:12:3: (st= statement[symTab] )
			// ./src/VSLTreeParser.g:19:7: st= statement[symTab]
			{
			pushFollow(FOLLOW_statement_in_s69);
			st=statement(symTab);
			state._fsp--;


			      System.out.println("declaration");
			      code = st;
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "s"



	// $ANTLR start "statement"
	// ./src/VSLTreeParser.g:27:1: statement[SymbolTable symTab] returns [Code3a code3a] : b= block[symTab] ;
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a b =null;

		try {
			// ./src/VSLTreeParser.g:28:3: (b= block[symTab] )
			// ./src/VSLTreeParser.g:36:7: b= block[symTab]
			{
			pushFollow(FOLLOW_block_in_statement99);
			b=block(symTab);
			state._fsp--;


			        System.out.println("statement");
			        //System.out.println(b);
			        code3a=b;
			      
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "statement"



	// $ANTLR start "block"
	// ./src/VSLTreeParser.g:45:1: block[SymbolTable symTab] returns [Code3a code3a] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a d =null;
		Code3a il =null;

		try {
			// ./src/VSLTreeParser.g:46:3: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==BLOCK) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==DOWN) ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2==DECL) ) {
						alt1=1;
					}
					else if ( (LA1_2==INST) ) {
						alt1=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// ./src/VSLTreeParser.g:46:5: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block128); 

					      System.out.println("block0");
					      symTab.enterScope();
					    
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block144);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block149);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      System.out.println("block");
					      code3a = d;
					      System.out.println(d);
					      code3a.append(il);
					      symTab.leaveScope();
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:60:5: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block165); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block169);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      System.out.println("block2");
					      code3a = il;
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "block"



	// $ANTLR start "inst_list"
	// ./src/VSLTreeParser.g:69:1: inst_list[SymbolTable symTab] returns [Code3a code3a] : ^( INST (il= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a il =null;


		      code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:74:3: ( ^( INST (il= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:74:5: ^( INST (il= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list211); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:74:11: (il= statement[symTab] )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==BLOCK) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// ./src/VSLTreeParser.g:75:7: il= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list222);
					il=statement(symTab);
					state._fsp--;


					        code3a.append(il);
					      
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "inst_list"



	// $ANTLR start "expression"
	// ./src/VSLTreeParser.g:83:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute e =null;
		ExpAttribute pe =null;

		try {
			// ./src/VSLTreeParser.g:84:3: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt3=6;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt3=1;
				}
				break;
			case MINUS:
				{
				alt3=2;
				}
				break;
			case MUL:
				{
				alt3=3;
				}
				break;
			case DIV:
				{
				alt3=4;
				}
				break;
			case NEGAT:
				{
				alt3=5;
				}
				break;
			case IDENT:
			case INTEGER:
				{
				alt3=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// ./src/VSLTreeParser.g:85:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression266); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression270);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression275);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:94:5: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression298); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression302);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression307);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:103:5: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression329); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression333);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression338);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:112:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression360); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression364);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression369);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:121:5: ^( NEGAT e= expression[symTab] )
					{
					match(input,NEGAT,FOLLOW_NEGAT_in_expression391); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression395);
					e=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      Type ty = TypeCheck.checkUnOp(e.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genUnOp(Inst3a.TAC.NEG, temp, e);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 6 :
					// ./src/VSLTreeParser.g:129:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression412);
					pe=primary_exp(symTab);
					state._fsp--;

					 
					      expAtt = pe; 
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "expression"



	// $ANTLR start "primary_exp"
	// ./src/VSLTreeParser.g:137:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER1=null;
		CommonTree IDENT2=null;

		try {
			// ./src/VSLTreeParser.g:138:3: ( INTEGER | IDENT )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==INTEGER) ) {
				alt4=1;
			}
			else if ( (LA4_0==IDENT) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// ./src/VSLTreeParser.g:138:5: INTEGER
					{
					INTEGER1=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp440); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER1!=null?INTEGER1.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:144:5: IDENT
					{
					IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp453); 

					      Operand3a id = symTab.lookup((IDENT2!=null?IDENT2.getText():null));
					      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT2!=null?IDENT2.getText():null)));
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "primary_exp"



	// $ANTLR start "declaration"
	// ./src/VSLTreeParser.g:152:1: declaration[SymbolTable symTab] returns [Code3a code3a] : ^( DECL (value= decl_list[symTab] ) ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a value =null;

		try {
			// ./src/VSLTreeParser.g:153:3: ( ^( DECL (value= decl_list[symTab] ) ) )
			// ./src/VSLTreeParser.g:153:5: ^( DECL (value= decl_list[symTab] ) )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration479); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:153:12: (value= decl_list[symTab] )
			// ./src/VSLTreeParser.g:153:13: value= decl_list[symTab]
			{
			pushFollow(FOLLOW_decl_list_in_declaration486);
			value=decl_list(symTab);
			state._fsp--;


			      code3a = value;
			    
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "declaration"



	// $ANTLR start "decl_list"
	// ./src/VSLTreeParser.g:160:1: decl_list[SymbolTable symTab] returns [Code3a code3a] : (value= decl_item[symTab] )+ ;
	public final Code3a decl_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a value =null;


		      code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:165:5: ( (value= decl_item[symTab] )+ )
			// ./src/VSLTreeParser.g:166:9: (value= decl_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:166:9: (value= decl_item[symTab] )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==IDENT) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// ./src/VSLTreeParser.g:167:11: value= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_decl_list553);
					value=decl_item(symTab);
					state._fsp--;


					            code3a.append(value);
					          
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "decl_list"



	// $ANTLR start "decl_item"
	// ./src/VSLTreeParser.g:175:1: decl_item[SymbolTable symTab] returns [Code3a code3a] : IDENT ;
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT3=null;

		try {
			// ./src/VSLTreeParser.g:176:3: ( IDENT )
			// ./src/VSLTreeParser.g:176:5: IDENT
			{
			IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item596); 

			    code3a.append(Code3aGenerator.genDeclVar(symTab, (IDENT3!=null?IDENT3.getText():null)));
			  
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code3a;
	}
	// $ANTLR end "decl_item"

	// Delegated rules



	public static final BitSet FOLLOW_statement_in_s69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_statement99 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block128 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block144 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block149 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block165 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block169 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list211 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list222 = new BitSet(new long[]{0x0000020000000008L});
	public static final BitSet FOLLOW_PLUS_in_expression266 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression270 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression275 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression298 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression302 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression307 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression329 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression333 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression338 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression360 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression364 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression369 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGAT_in_expression391 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression395 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECL_in_declaration479 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_list_in_declaration486 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_item_in_decl_list553 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_IDENT_in_decl_item596 = new BitSet(new long[]{0x0000000000000002L});
}
