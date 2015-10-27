// $ANTLR 3.5 ./src/VSLTreeParser.g 2015-10-27 20:40:20

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
	// ./src/VSLTreeParser.g:11:1: s[SymbolTable symTab] returns [Code3a code] : (e= expression[symTab] |st= statement[symTab] );
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		ExpAttribute e =null;
		Code3a st =null;

		try {
			// ./src/VSLTreeParser.g:12:2: (e= expression[symTab] |st= statement[symTab] )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==DIV||LA1_0==IDENT||LA1_0==INTEGER||(LA1_0 >= MINUS && LA1_0 <= MUL)||LA1_0==PLUS||LA1_0==NEGAT) ) {
				alt1=1;
			}
			else if ( (LA1_0==ASSIGN_KW||LA1_0==IF_KW||LA1_0==PRINT_KW||LA1_0==READ_KW||LA1_0==BLOCK) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// ./src/VSLTreeParser.g:13:3: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_s69);
					e=expression(symTab);
					state._fsp--;


						 		code = e.code;
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:20:3: st= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_s86);
					st=statement(symTab);
					state._fsp--;


						  		code = st;
							
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
		return code;
	}
	// $ANTLR end "s"



	// $ANTLR start "statement"
	// ./src/VSLTreeParser.g:27:1: statement[SymbolTable symTab] returns [Code3a code3a] : ( ^( ASSIGN_KW e1= expression[symTab] IDENT () ) |b= block[symTab] | ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( PRINT_KW pr= print_list[symTab] ) | ^( READ_KW read_list[symTab] ) );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT1=null;
		ExpAttribute e1 =null;
		Code3a b =null;
		Code3a s1 =null;
		Code3a s2 =null;
		Code3a pr =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:32:4: ( ^( ASSIGN_KW e1= expression[symTab] IDENT () ) |b= block[symTab] | ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( PRINT_KW pr= print_list[symTab] ) | ^( READ_KW read_list[symTab] ) )
			int alt3=5;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt3=1;
				}
				break;
			case BLOCK:
				{
				alt3=2;
				}
				break;
			case IF_KW:
				{
				alt3=3;
				}
				break;
			case PRINT_KW:
				{
				alt3=4;
				}
				break;
			case READ_KW:
				{
				alt3=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// ./src/VSLTreeParser.g:33:5: ^( ASSIGN_KW e1= expression[symTab] IDENT () )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement130); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement134);
					e1=expression(symTab);
					state._fsp--;

					IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement137); 
					// ./src/VSLTreeParser.g:34:9: ()
					// ./src/VSLTreeParser.g:35:11: 
					{

					          			code3a = Code3aGenerator.genAssignExpr(symTab, e1, (IDENT1!=null?IDENT1.getText():null));
					        		
					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:43:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement192);
					b=block(symTab);
					state._fsp--;


					        	code3a = b;
					    	
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:50:6: ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement223); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement233);
					e1=expression(symTab);
					state._fsp--;


					    			LabelSymbol l_else = SymbDistrib.newLabel();
					    			LabelSymbol l_end = SymbDistrib.newLabel();
					    			code3a = Code3aGenerator.genIfExpr(e1, l_else);
					    		
					pushFollow(FOLLOW_statement_in_statement255);
					s1=statement(symTab);
					state._fsp--;


					    			code3a.append(s1);
					    			code3a.append(Code3aGenerator.genGoTo(l_end));
					    			code3a.append(Code3aGenerator.genLabel(l_else));
					    		
					// ./src/VSLTreeParser.g:65:7: (s2= statement[symTab] )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==ASSIGN_KW||LA2_0==IF_KW||LA2_0==PRINT_KW||LA2_0==READ_KW||LA2_0==BLOCK) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// ./src/VSLTreeParser.g:66:8: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement285);
							s2=statement(symTab);
							state._fsp--;


							    				code3a.append(s2);
							    			
							}
							break;

					}


					    			code3a.append(Code3aGenerator.genLabel(l_end));
					    		
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:78:6: ^( PRINT_KW pr= print_list[symTab] )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement342); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_print_list_in_statement352);
					pr=print_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					    		code3a = pr;
					    	
					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:88:6: ^( READ_KW read_list[symTab] )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement391); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_read_list_in_statement399);
					read_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 



					    	
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
	// $ANTLR end "statement"



	// $ANTLR start "block"
	// ./src/VSLTreeParser.g:98:1: block[SymbolTable symTab] returns [Code3a code3a] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a d =null;
		Code3a il =null;


		      code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:103:2: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==BLOCK) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==DOWN) ) {
					int LA4_2 = input.LA(3);
					if ( (LA4_2==DECL) ) {
						alt4=1;
					}
					else if ( (LA4_2==INST) ) {
						alt4=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 2, input);
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
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// ./src/VSLTreeParser.g:104:3: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block447); 

					      		symTab.enterScope();
					    	
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block465);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block470);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      		code3a = d;
					      		code3a.append(il);
					      		symTab.leaveScope();
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:119:4: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block497); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block501);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


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
	// ./src/VSLTreeParser.g:126:1: inst_list[SymbolTable symTab] returns [Code3a code3a] : ^( INST (il= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a il =null;


		      	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:131:4: ( ^( INST (il= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:132:5: ^( INST (il= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list553); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:133:10: (il= statement[symTab] )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==ASSIGN_KW||LA5_0==IF_KW||LA5_0==PRINT_KW||LA5_0==READ_KW||LA5_0==BLOCK) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// ./src/VSLTreeParser.g:134:10: il= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list567);
					il=statement(symTab);
					state._fsp--;


					        			code3a.append(il);
					      			
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
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
	// ./src/VSLTreeParser.g:143:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute e =null;
		ExpAttribute pe =null;

		try {
			// ./src/VSLTreeParser.g:144:4: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt6=6;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt6=1;
				}
				break;
			case MINUS:
				{
				alt6=2;
				}
				break;
			case MUL:
				{
				alt6=3;
				}
				break;
			case DIV:
				{
				alt6=4;
				}
				break;
			case NEGAT:
				{
				alt6=5;
				}
				break;
			case IDENT:
			case INTEGER:
				{
				alt6=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// ./src/VSLTreeParser.g:146:6: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression628); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression632);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression637);
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
					// ./src/VSLTreeParser.g:157:6: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression668); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression672);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression677);
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
					// ./src/VSLTreeParser.g:168:6: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression707); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression711);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression716);
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
					// ./src/VSLTreeParser.g:179:6: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression746); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression750);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression755);
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
					// ./src/VSLTreeParser.g:190:6: ^( NEGAT e= expression[symTab] )
					{
					match(input,NEGAT,FOLLOW_NEGAT_in_expression785); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression789);
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
					// ./src/VSLTreeParser.g:200:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression813);
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
	// ./src/VSLTreeParser.g:208:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER2=null;
		CommonTree IDENT3=null;

		try {
			// ./src/VSLTreeParser.g:209:4: ( INTEGER | IDENT )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==INTEGER) ) {
				alt7=1;
			}
			else if ( (LA7_0==IDENT) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// ./src/VSLTreeParser.g:210:5: INTEGER
					{
					INTEGER2=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp847); 

					      		ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER2!=null?INTEGER2.getText():null)));
					      		expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:218:5: IDENT
					{
					IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp867); 

					      		Operand3a id = symTab.lookup((IDENT3!=null?IDENT3.getText():null));
					      		expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT3!=null?IDENT3.getText():null)));
					    	
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



	// $ANTLR start "print_list"
	// ./src/VSLTreeParser.g:225:1: print_list[SymbolTable symTab] returns [Code3a code3a] : (pr_list= print_item[symTab] )+ ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a pr_list =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:230:2: ( (pr_list= print_item[symTab] )+ )
			// ./src/VSLTreeParser.g:231:3: (pr_list= print_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:231:3: (pr_list= print_item[symTab] )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==DIV||LA8_0==IDENT||LA8_0==INTEGER||(LA8_0 >= MINUS && LA8_0 <= MUL)||LA8_0==PLUS||LA8_0==TEXT||LA8_0==NEGAT) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// ./src/VSLTreeParser.g:232:4: pr_list= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list909);
					pr_list=print_item(symTab);
					state._fsp--;


									code3a.append(pr_list);
								
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
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
	// $ANTLR end "print_list"



	// $ANTLR start "print_item"
	// ./src/VSLTreeParser.g:239:1: print_item[SymbolTable symTab] returns [Code3a code3a] : ( TEXT |e= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree TEXT4=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:240:2: ( TEXT |e= expression[symTab] )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==TEXT) ) {
				alt9=1;
			}
			else if ( (LA9_0==DIV||LA9_0==IDENT||LA9_0==INTEGER||(LA9_0 >= MINUS && LA9_0 <= MUL)||LA9_0==PLUS||LA9_0==NEGAT) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// ./src/VSLTreeParser.g:241:3: TEXT
					{
					TEXT4=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item938); 

								code3a = Code3aGenerator.genPrintString((TEXT4!=null?TEXT4.getText():null));	
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:248:3: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item953);
					e=expression(symTab);
					state._fsp--;



							
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
	// $ANTLR end "print_item"



	// $ANTLR start "read_list"
	// ./src/VSLTreeParser.g:254:1: read_list[SymbolTable symTab] returns [Code3a code3a] : (rl= read_item[symTab] )+ ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a rl =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:259:2: ( (rl= read_item[symTab] )+ )
			// ./src/VSLTreeParser.g:260:3: (rl= read_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:260:3: (rl= read_item[symTab] )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==IDENT) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// ./src/VSLTreeParser.g:261:4: rl= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list990);
					rl=read_item(symTab);
					state._fsp--;


									code3a.append(rl);
								
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
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
	// $ANTLR end "read_list"



	// $ANTLR start "read_item"
	// ./src/VSLTreeParser.g:268:1: read_item[SymbolTable symTab] returns [Code3a code3a] : IDENT ;
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		try {
			// ./src/VSLTreeParser.g:269:2: ( IDENT )
			// ./src/VSLTreeParser.g:270:3: IDENT
			{
			match(input,IDENT,FOLLOW_IDENT_in_read_item1019); 


					
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
	// $ANTLR end "read_item"



	// $ANTLR start "declaration"
	// ./src/VSLTreeParser.g:279:1: declaration[SymbolTable symTab] returns [Code3a code3a] : ^( DECL (value= decl_item[symTab] )+ ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a value =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:284:4: ( ^( DECL (value= decl_item[symTab] )+ ) )
			// ./src/VSLTreeParser.g:284:7: ^( DECL (value= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration1059); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:285:4: (value= decl_item[symTab] )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==IDENT) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// ./src/VSLTreeParser.g:285:5: value= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration1070);
					value=decl_item(symTab);
					state._fsp--;


					      				code3a.append(value);
					    			
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
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



	// $ANTLR start "decl_item"
	// ./src/VSLTreeParser.g:294:1: decl_item[SymbolTable symTab] returns [Code3a code3a] : IDENT ;
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT5=null;


		     	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:299:4: ( IDENT )
			// ./src/VSLTreeParser.g:300:5: IDENT
			{
			IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1132); 

						code3a.append(Code3aGenerator.genDeclVar(symTab, (IDENT5!=null?IDENT5.getText():null)));
						symTab.print();
				  	
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



	public static final BitSet FOLLOW_expression_in_s69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_s86 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement130 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement134 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement137 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KW_in_statement223 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement233 = new BitSet(new long[]{0x0000020044008020L});
	public static final BitSet FOLLOW_statement_in_statement255 = new BitSet(new long[]{0x0000020044008028L});
	public static final BitSet FOLLOW_statement_in_statement285 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement342 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_statement352 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_statement391 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_statement399 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block447 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block465 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block470 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block497 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block501 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list553 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list567 = new BitSet(new long[]{0x0000020044008028L});
	public static final BitSet FOLLOW_PLUS_in_expression628 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression632 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression637 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression668 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression672 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression677 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression707 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression711 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression716 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression746 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression750 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression755 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGAT_in_expression785 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression789 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression813 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp847 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_item_in_print_list909 = new BitSet(new long[]{0x0000800202C14202L});
	public static final BitSet FOLLOW_TEXT_in_print_item938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item953 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_item_in_read_list990 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_IDENT_in_read_item1019 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECL_in_declaration1059 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration1070 = new BitSet(new long[]{0x0000000000004008L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1132 = new BitSet(new long[]{0x0000000000000002L});
}
