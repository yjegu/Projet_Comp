// $ANTLR 3.5 ./src/VSLTreeParser.g 2015-11-21 23:45:27

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
	// ./src/VSLTreeParser.g:11:1: s[SymbolTable symTab] returns [Code3a code3a] : p= program[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a p =null;

		try {
			// ./src/VSLTreeParser.g:12:2: (p= program[symTab] )
			// ./src/VSLTreeParser.g:13:3: p= program[symTab]
			{
			pushFollow(FOLLOW_program_in_s69);
			p=program(symTab);
			state._fsp--;


						code3a = p;
						System.out.println("symTab at the end of the program :");
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
	// $ANTLR end "s"



	// $ANTLR start "program"
	// ./src/VSLTreeParser.g:21:1: program[SymbolTable symTab] returns [Code3a code3a] : ^( PROG (u= unit[symTab] )+ ) ;
	public final Code3a program(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a u =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:26:2: ( ^( PROG (u= unit[symTab] )+ ) )
			// ./src/VSLTreeParser.g:28:3: ^( PROG (u= unit[symTab] )+ )
			{
			match(input,PROG,FOLLOW_PROG_in_program105); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:30:4: (u= unit[symTab] )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FUNC_KW||LA1_0==PROTO_KW) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// ./src/VSLTreeParser.g:31:5: u= unit[symTab]
					{
					pushFollow(FOLLOW_unit_in_program118);
					u=unit(symTab);
					state._fsp--;


										code3a.append(u);
									
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
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
	// $ANTLR end "program"



	// $ANTLR start "unit"
	// ./src/VSLTreeParser.g:39:1: unit[SymbolTable symTab] returns [Code3a code3a] : (f= function[symTab] |p= proto[symTab] );
	public final Code3a unit(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a f =null;
		Code3a p =null;

		try {
			// ./src/VSLTreeParser.g:40:5: (f= function[symTab] |p= proto[symTab] )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==FUNC_KW) ) {
				alt2=1;
			}
			else if ( (LA2_0==PROTO_KW) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// ./src/VSLTreeParser.g:41:6: f= function[symTab]
					{
					pushFollow(FOLLOW_function_in_unit161);
					f=function(symTab);
					state._fsp--;


					    		code3a = f;
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:46:6: p= proto[symTab]
					{
					pushFollow(FOLLOW_proto_in_unit184);
					p=proto(symTab);
					state._fsp--;


					    		code3a = p;
					    	
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
	// $ANTLR end "unit"



	// $ANTLR start "proto"
	// ./src/VSLTreeParser.g:53:1: proto[SymbolTable symTab] returns [Code3a code3a] : ^( PROTO_KW t= type[symTab] IDENT p= param_list[symTab] ) ;
	public final Code3a proto(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT1=null;
		CommonTree PROTO_KW2=null;
		Type t =null;
		List<VarSymbol> p =null;

		try {
			// ./src/VSLTreeParser.g:54:2: ( ^( PROTO_KW t= type[symTab] IDENT p= param_list[symTab] ) )
			// ./src/VSLTreeParser.g:55:3: ^( PROTO_KW t= type[symTab] IDENT p= param_list[symTab] )
			{
			PROTO_KW2=(CommonTree)match(input,PROTO_KW,FOLLOW_PROTO_KW_in_proto221); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_proto228);
			t=type(symTab);
			state._fsp--;

			IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_proto234); 
			pushFollow(FOLLOW_param_list_in_proto241);
			p=param_list(symTab);
			state._fsp--;


							code3a = Code3aGenerator.genFunctionSignature(symTab, (IDENT1!=null?IDENT1.getText():null), t, p, true, PROTO_KW2);
						
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
	// $ANTLR end "proto"



	// $ANTLR start "function"
	// ./src/VSLTreeParser.g:67:1: function[SymbolTable symTab] returns [Code3a code3a] : ^( FUNC_KW t= type[symTab] IDENT p= param_list[symTab] ^( BODY st= statement[symTab] ) ) ;
	public final Code3a function(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT3=null;
		CommonTree FUNC_KW4=null;
		Type t =null;
		List<VarSymbol> p =null;
		Code3a st =null;

		try {
			// ./src/VSLTreeParser.g:68:2: ( ^( FUNC_KW t= type[symTab] IDENT p= param_list[symTab] ^( BODY st= statement[symTab] ) ) )
			// ./src/VSLTreeParser.g:69:3: ^( FUNC_KW t= type[symTab] IDENT p= param_list[symTab] ^( BODY st= statement[symTab] ) )
			{
			FUNC_KW4=(CommonTree)match(input,FUNC_KW,FOLLOW_FUNC_KW_in_function276); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_function283);
			t=type(symTab);
			state._fsp--;

			IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function289); 
			pushFollow(FOLLOW_param_list_in_function296);
			p=param_list(symTab);
			state._fsp--;


							code3a = Code3aGenerator.genFunctionSignature(symTab, (IDENT3!=null?IDENT3.getText():null), t, p, false, FUNC_KW4);
						
			match(input,BODY,FOLLOW_BODY_in_function314); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function322);
			st=statement(symTab);
			state._fsp--;


								code3a.append(st);
							
			match(input, Token.UP, null); 


							symTab.leaveScope();
							code3a.append(Code3aGenerator.genEndFunc());
						
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
	// $ANTLR end "function"



	// $ANTLR start "type"
	// ./src/VSLTreeParser.g:93:1: type[SymbolTable symTab] returns [Type typeFunc] : ( INT_KW | VOID_KW );
	public final Type type(SymbolTable symTab) throws RecognitionException {
		Type typeFunc = null;


		try {
			// ./src/VSLTreeParser.g:94:2: ( INT_KW | VOID_KW )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==INT_KW) ) {
				alt3=1;
			}
			else if ( (LA3_0==VOID_KW) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// ./src/VSLTreeParser.g:95:3: INT_KW
					{
					match(input,INT_KW,FOLLOW_INT_KW_in_type363); 

								typeFunc = Type.INT;
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:100:3: VOID_KW
					{
					match(input,VOID_KW,FOLLOW_VOID_KW_in_type374); 

								typeFunc = Type.VOID;
							
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
		return typeFunc;
	}
	// $ANTLR end "type"



	// $ANTLR start "param_list"
	// ./src/VSLTreeParser.g:107:1: param_list[SymbolTable symTab] returns [List<VarSymbol> vars] : ( ^( PARAM (par= param[symTab] )* ) | PARAM );
	public final List<VarSymbol> param_list(SymbolTable symTab) throws RecognitionException {
		List<VarSymbol> vars = null;


		VarSymbol par =null;


				vars = new ArrayList<VarSymbol>();
			
		try {
			// ./src/VSLTreeParser.g:112:2: ( ^( PARAM (par= param[symTab] )* ) | PARAM )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==PARAM) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==DOWN) ) {
					alt5=1;
				}
				else if ( (LA5_1==UP||LA5_1==BODY) ) {
					alt5=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// ./src/VSLTreeParser.g:113:3: ^( PARAM (par= param[symTab] )* )
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list410); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// ./src/VSLTreeParser.g:114:9: (par= param[symTab] )*
						loop4:
						while (true) {
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0==IDENT||LA4_0==ARRAY) ) {
								alt4=1;
							}

							switch (alt4) {
							case 1 :
								// ./src/VSLTreeParser.g:115:5: par= param[symTab]
								{
								pushFollow(FOLLOW_param_in_param_list419);
								par=param(symTab);
								state._fsp--;


													vars.add(par);
												
								}
								break;

							default :
								break loop4;
							}
						}

						match(input, Token.UP, null); 
					}

					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:123:3: PARAM
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list444); 
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
		return vars;
	}
	// $ANTLR end "param_list"



	// $ANTLR start "param"
	// ./src/VSLTreeParser.g:126:1: param[SymbolTable symTab] returns [VarSymbol param] : ( IDENT | ^( ARRAY IDENT ) );
	public final VarSymbol param(SymbolTable symTab) throws RecognitionException {
		VarSymbol param = null;


		CommonTree IDENT5=null;

		try {
			// ./src/VSLTreeParser.g:127:2: ( IDENT | ^( ARRAY IDENT ) )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==IDENT) ) {
				alt6=1;
			}
			else if ( (LA6_0==ARRAY) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// ./src/VSLTreeParser.g:128:3: IDENT
					{
					IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param462); 

								param = Code3aGenerator.genParam(symTab, (IDENT5!=null?IDENT5.getText():null));
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:135:3: ^( ARRAY IDENT )
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_param480); 
					match(input, Token.DOWN, null); 
					match(input,IDENT,FOLLOW_IDENT_in_param485); 
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
		return param;
	}
	// $ANTLR end "param"



	// $ANTLR start "statement"
	// ./src/VSLTreeParser.g:142:1: statement[SymbolTable symTab] returns [Code3a code3a] : ( ^( ASSIGN_KW e1= expression[symTab] ( ( IDENT ) | (a= array_elem[symTab] ) ) ) |b= block[symTab] | ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pr= print_list[symTab] ) | ^( READ_KW r= read_list[symTab] ) | ^( RETURN_KW e= expression[symTab] ) | ^( FCALL_S IDENT (al= argument_list[symTab] )? ) );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT6=null;
		CommonTree ASSIGN_KW7=null;
		CommonTree RETURN_KW8=null;
		CommonTree IDENT9=null;
		CommonTree FCALL_S10=null;
		ExpAttribute e1 =null;
		ExpArrayAttribute a =null;
		Code3a b =null;
		Code3a s1 =null;
		Code3a s2 =null;
		ExpAttribute e =null;
		Code3a st =null;
		Code3a pr =null;
		Code3a r =null;
		TreeRuleReturnScope al =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:147:4: ( ^( ASSIGN_KW e1= expression[symTab] ( ( IDENT ) | (a= array_elem[symTab] ) ) ) |b= block[symTab] | ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pr= print_list[symTab] ) | ^( READ_KW r= read_list[symTab] ) | ^( RETURN_KW e= expression[symTab] ) | ^( FCALL_S IDENT (al= argument_list[symTab] )? ) )
			int alt10=8;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt10=1;
				}
				break;
			case BLOCK:
				{
				alt10=2;
				}
				break;
			case IF_KW:
				{
				alt10=3;
				}
				break;
			case WHILE_KW:
				{
				alt10=4;
				}
				break;
			case PRINT_KW:
				{
				alt10=5;
				}
				break;
			case READ_KW:
				{
				alt10=6;
				}
				break;
			case RETURN_KW:
				{
				alt10=7;
				}
				break;
			case FCALL_S:
				{
				alt10=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// ./src/VSLTreeParser.g:148:5: ^( ASSIGN_KW e1= expression[symTab] ( ( IDENT ) | (a= array_elem[symTab] ) ) )
					{
					ASSIGN_KW7=(CommonTree)match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement534); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement543);
					e1=expression(symTab);
					state._fsp--;

					// ./src/VSLTreeParser.g:151:6: ( ( IDENT ) | (a= array_elem[symTab] ) )
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==IDENT) ) {
						alt7=1;
					}
					else if ( (LA7_0==ARELEM) ) {
						alt7=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 7, 0, input);
						throw nvae;
					}

					switch (alt7) {
						case 1 :
							// ./src/VSLTreeParser.g:152:7: ( IDENT )
							{
							// ./src/VSLTreeParser.g:152:7: ( IDENT )
							// ./src/VSLTreeParser.g:153:8: IDENT
							{
							IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement569); 

							          				code3a = Code3aGenerator.genAffExpr(symTab, e1, (IDENT6!=null?IDENT6.getText():null), ASSIGN_KW7);
							        			
							}

							}
							break;
						case 2 :
							// ./src/VSLTreeParser.g:161:10: (a= array_elem[symTab] )
							{
							// ./src/VSLTreeParser.g:161:10: (a= array_elem[symTab] )
							// ./src/VSLTreeParser.g:162:11: a= array_elem[symTab]
							{
							pushFollow(FOLLOW_array_elem_in_statement631);
							a=array_elem(symTab);
							state._fsp--;


							      					code3a = e1.code;
							      					code3a.append(Code3aGenerator.genVarTab(a, e1.place));
							      				
							}

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:173:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement687);
					b=block(symTab);
					state._fsp--;


					        	code3a = b;
					    	
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:180:6: ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement718); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement728);
					e1=expression(symTab);
					state._fsp--;


					    			LabelSymbol l_else = SymbDistrib.newLabel();
					    			LabelSymbol l_end = SymbDistrib.newLabel();
					    			code3a = Code3aGenerator.genIfStatement(e1, l_else);
					    		
					pushFollow(FOLLOW_statement_in_statement750);
					s1=statement(symTab);
					state._fsp--;


					    			code3a.append(s1);
					    			code3a.append(Code3aGenerator.genGoTo(l_end));
					    			code3a.append(Code3aGenerator.genLabel(l_else));
					    		
					// ./src/VSLTreeParser.g:195:7: (s2= statement[symTab] )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==ASSIGN_KW||LA8_0==IF_KW||LA8_0==PRINT_KW||(LA8_0 >= READ_KW && LA8_0 <= RETURN_KW)||LA8_0==WHILE_KW||LA8_0==BLOCK||LA8_0==FCALL_S) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// ./src/VSLTreeParser.g:196:8: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement780);
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
					// ./src/VSLTreeParser.g:208:7: ^( WHILE_KW e= expression[symTab] st= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement840); 

					          LabelSymbol l_while = SymbDistrib.newLabel();
					          LabelSymbol l_end = SymbDistrib.newLabel();
					        
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement863);
					e=expression(symTab);
					state._fsp--;


					        	code3a = Code3aGenerator.genLabel(l_while);
								code3a.append(Code3aGenerator.genWhileStatement(e, l_end));
					        
					pushFollow(FOLLOW_statement_in_statement887);
					st=statement(symTab);
					state._fsp--;


					          code3a.append(st);
					          code3a.append(Code3aGenerator.genGoTo(l_while));
					          code3a.append(Code3aGenerator.genLabel(l_end));
					        
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:231:6: ^( PRINT_KW pr= print_list[symTab] )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement930); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_print_list_in_statement940);
					pr=print_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					    		code3a = pr;
					    	
					}
					break;
				case 6 :
					// ./src/VSLTreeParser.g:241:6: ^( READ_KW r= read_list[symTab] )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement979); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_read_list_in_statement989);
					r=read_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        	code3a = r;
					    	
					}
					break;
				case 7 :
					// ./src/VSLTreeParser.g:250:6: ^( RETURN_KW e= expression[symTab] )
					{
					RETURN_KW8=(CommonTree)match(input,RETURN_KW,FOLLOW_RETURN_KW_in_statement1026); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement1036);
					e=expression(symTab);
					state._fsp--;


					    			code3a = Code3aGenerator.genReturn(e, RETURN_KW8);
					    		
					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// ./src/VSLTreeParser.g:260:6: ^( FCALL_S IDENT (al= argument_list[symTab] )? )
					{
					FCALL_S10=(CommonTree)match(input,FCALL_S,FOLLOW_FCALL_S_in_statement1075); 
					match(input, Token.DOWN, null); 
					IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement1083); 
					// ./src/VSLTreeParser.g:263:7: (al= argument_list[symTab] )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==DIV||LA9_0==IDENT||LA9_0==INTEGER||(LA9_0 >= MINUS && LA9_0 <= MUL)||LA9_0==PLUS||LA9_0==ARELEM||LA9_0==FCALL) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// ./src/VSLTreeParser.g:264:8: al= argument_list[symTab]
							{
							pushFollow(FOLLOW_argument_list_in_statement1102);
							al=argument_list(symTab);
							state._fsp--;

							}
							break;

					}


					    			code3a = Code3aGenerator.genFunctionCallInStatement(symTab, (IDENT9!=null?IDENT9.getText():null), (argument_list_return) al, FCALL_S10);
					    		
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
	// ./src/VSLTreeParser.g:273:1: block[SymbolTable symTab] returns [Code3a code3a] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a d =null;
		Code3a il =null;


		      code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:278:2: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==BLOCK) ) {
				int LA11_1 = input.LA(2);
				if ( (LA11_1==DOWN) ) {
					int LA11_2 = input.LA(3);
					if ( (LA11_2==DECL) ) {
						alt11=1;
					}
					else if ( (LA11_2==INST) ) {
						alt11=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 11, 2, input);
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
							new NoViableAltException("", 11, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// ./src/VSLTreeParser.g:279:3: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block1160); 

					      		symTab.enterScope();
					    	
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block1178);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block1183);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      		code3a = d;
					      		code3a.append(il);
					      		symTab.leaveScope();
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:294:4: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block1210); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block1214);
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
	// ./src/VSLTreeParser.g:301:1: inst_list[SymbolTable symTab] returns [Code3a code3a] : ^( INST (il= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a il =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:306:2: ( ^( INST (il= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:307:3: ^( INST (il= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list1255); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:308:8: (il= statement[symTab] )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==ASSIGN_KW||LA12_0==IF_KW||LA12_0==PRINT_KW||(LA12_0 >= READ_KW && LA12_0 <= RETURN_KW)||LA12_0==WHILE_KW||LA12_0==BLOCK||LA12_0==FCALL_S) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// ./src/VSLTreeParser.g:309:5: il= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list1264);
					il=statement(symTab);
					state._fsp--;


										code3a.append(il);
									
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
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



	// $ANTLR start "array_elem"
	// ./src/VSLTreeParser.g:317:1: array_elem[SymbolTable symTab] returns [ExpArrayAttribute exp] : ^( ARELEM IDENT e= expression[symTab] ) ;
	public final ExpArrayAttribute array_elem(SymbolTable symTab) throws RecognitionException {
		ExpArrayAttribute exp = null;


		CommonTree IDENT11=null;
		CommonTree ARELEM12=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:318:5: ( ^( ARELEM IDENT e= expression[symTab] ) )
			// ./src/VSLTreeParser.g:319:3: ^( ARELEM IDENT e= expression[symTab] )
			{
			ARELEM12=(CommonTree)match(input,ARELEM,FOLLOW_ARELEM_in_array_elem1307); 
			match(input, Token.DOWN, null); 
			IDENT11=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem1313); 
			pushFollow(FOLLOW_expression_in_array_elem1320);
			e=expression(symTab);
			state._fsp--;


							exp = Code3aGenerator.genArrayElement(symTab, (IDENT11!=null?IDENT11.getText():null), e, ARELEM12);
						
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
		return exp;
	}
	// $ANTLR end "array_elem"



	// $ANTLR start "expression"
	// ./src/VSLTreeParser.g:330:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// ./src/VSLTreeParser.g:331:4: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt13=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt13=1;
				}
				break;
			case MINUS:
				{
				alt13=2;
				}
				break;
			case MUL:
				{
				alt13=3;
				}
				break;
			case DIV:
				{
				alt13=4;
				}
				break;
			case IDENT:
			case INTEGER:
			case ARELEM:
			case FCALL:
				{
				alt13=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// ./src/VSLTreeParser.g:333:6: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression1363); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1367);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1372);
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
					// ./src/VSLTreeParser.g:344:6: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression1403); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1407);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1412);
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
					// ./src/VSLTreeParser.g:355:6: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression1442); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1446);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1451);
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
					// ./src/VSLTreeParser.g:366:6: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression1481); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1485);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1490);
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
					// ./src/VSLTreeParser.g:376:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression1514);
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
	// ./src/VSLTreeParser.g:384:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT | ^( FCALL IDENT (al= argument_list[symTab] )? ) |a= array_elem[symTab] );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER13=null;
		CommonTree IDENT14=null;
		CommonTree IDENT15=null;
		CommonTree FCALL16=null;
		TreeRuleReturnScope al =null;
		ExpArrayAttribute a =null;

		try {
			// ./src/VSLTreeParser.g:385:4: ( INTEGER | IDENT | ^( FCALL IDENT (al= argument_list[symTab] )? ) |a= array_elem[symTab] )
			int alt15=4;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt15=1;
				}
				break;
			case IDENT:
				{
				alt15=2;
				}
				break;
			case FCALL:
				{
				alt15=3;
				}
				break;
			case ARELEM:
				{
				alt15=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// ./src/VSLTreeParser.g:386:5: INTEGER
					{
					INTEGER13=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp1548); 

					      		ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER13!=null?INTEGER13.getText():null)));
					      		expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:394:5: IDENT
					{
					IDENT14=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp1568); 

					      		Operand3a id = symTab.lookup((IDENT14!=null?IDENT14.getText():null));
					      		if(id == null) {
					      			Errors.unknownIdentifier(IDENT14, (IDENT14!=null?IDENT14.getText():null), null);
					      			System.err.println("Compilation terminated");
					      			System.exit(-1);
					      		}
					      		expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT14!=null?IDENT14.getText():null)));
					    	
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:407:6: ^( FCALL IDENT (al= argument_list[symTab] )? )
					{
					FCALL16=(CommonTree)match(input,FCALL,FOLLOW_FCALL_in_primary_exp1598); 
					match(input, Token.DOWN, null); 
					IDENT15=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp1606); 
					// ./src/VSLTreeParser.g:410:7: (al= argument_list[symTab] )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==DIV||LA14_0==IDENT||LA14_0==INTEGER||(LA14_0 >= MINUS && LA14_0 <= MUL)||LA14_0==PLUS||LA14_0==ARELEM||LA14_0==FCALL) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// ./src/VSLTreeParser.g:411:8: al= argument_list[symTab]
							{
							pushFollow(FOLLOW_argument_list_in_primary_exp1625);
							al=argument_list(symTab);
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					    		expAtt = Code3aGenerator.genFunctionCallInPrimaryExp(symTab, (IDENT15!=null?IDENT15.getText():null), (argument_list_return) al, FCALL16);
					    	
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:420:6: a= array_elem[symTab]
					{
					pushFollow(FOLLOW_array_elem_in_primary_exp1666);
					a=array_elem(symTab);
					state._fsp--;


					    		expAtt = a.exp;
					    	
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


	public static class argument_list_return extends TreeRuleReturnScope {
		public Code3a code;
		public List<Type> args;
	};


	// $ANTLR start "argument_list"
	// ./src/VSLTreeParser.g:426:1: argument_list[SymbolTable symTab] returns [Code3a code, List<Type> args] : (e= expression[symTab] )+ ;
	public final VSLTreeParser.argument_list_return argument_list(SymbolTable symTab) throws RecognitionException {
		VSLTreeParser.argument_list_return retval = new VSLTreeParser.argument_list_return();
		retval.start = input.LT(1);

		ExpAttribute e =null;


				retval.code = new Code3a();
				retval.args = new ArrayList<Type>();
			
		try {
			// ./src/VSLTreeParser.g:432:2: ( (e= expression[symTab] )+ )
			// ./src/VSLTreeParser.g:433:3: (e= expression[symTab] )+
			{
			// ./src/VSLTreeParser.g:433:3: (e= expression[symTab] )+
			int cnt16=0;
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==DIV||LA16_0==IDENT||LA16_0==INTEGER||(LA16_0 >= MINUS && LA16_0 <= MUL)||LA16_0==PLUS||LA16_0==ARELEM||LA16_0==FCALL) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// ./src/VSLTreeParser.g:434:4: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_argument_list1706);
					e=expression(symTab);
					state._fsp--;


									retval.args.add(e.type);
									retval.code.append(e.code);
									retval.code.append(Code3aGenerator.genArg(e.place));
								
					}
					break;

				default :
					if ( cnt16 >= 1 ) break loop16;
					EarlyExitException eee = new EarlyExitException(16, input);
					throw eee;
				}
				cnt16++;
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
		return retval;
	}
	// $ANTLR end "argument_list"



	// $ANTLR start "print_list"
	// ./src/VSLTreeParser.g:444:1: print_list[SymbolTable symTab] returns [Code3a code3a] : (pr_list= print_item[symTab] )+ ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a pr_list =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:449:2: ( (pr_list= print_item[symTab] )+ )
			// ./src/VSLTreeParser.g:450:3: (pr_list= print_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:450:3: (pr_list= print_item[symTab] )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==DIV||LA17_0==IDENT||LA17_0==INTEGER||(LA17_0 >= MINUS && LA17_0 <= MUL)||LA17_0==PLUS||LA17_0==TEXT||LA17_0==ARELEM||LA17_0==FCALL) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// ./src/VSLTreeParser.g:451:4: pr_list= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list1754);
					pr_list=print_item(symTab);
					state._fsp--;


									code3a.append(pr_list);
								
					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
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
	// ./src/VSLTreeParser.g:459:1: print_item[SymbolTable symTab] returns [Code3a code3a] : ( TEXT |e= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree TEXT17=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:460:2: ( TEXT |e= expression[symTab] )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==TEXT) ) {
				alt18=1;
			}
			else if ( (LA18_0==DIV||LA18_0==IDENT||LA18_0==INTEGER||(LA18_0 >= MINUS && LA18_0 <= MUL)||LA18_0==PLUS||LA18_0==ARELEM||LA18_0==FCALL) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// ./src/VSLTreeParser.g:461:3: TEXT
					{
					TEXT17=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item1785); 

								code3a = Code3aGenerator.genPrintString((TEXT17!=null?TEXT17.getText():null));	
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:468:3: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item1800);
					e=expression(symTab);
					state._fsp--;


								code3a = Code3aGenerator.genPrintExpr(e);
							
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
	// ./src/VSLTreeParser.g:475:1: read_list[SymbolTable symTab] returns [Code3a code3a] : (rl= read_item[symTab] )+ ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a rl =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:480:2: ( (rl= read_item[symTab] )+ )
			// ./src/VSLTreeParser.g:481:3: (rl= read_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:481:3: (rl= read_item[symTab] )+
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==IDENT||LA19_0==ARELEM) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// ./src/VSLTreeParser.g:482:4: rl= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list1839);
					rl=read_item(symTab);
					state._fsp--;


									code3a.append(rl);
								
					}
					break;

				default :
					if ( cnt19 >= 1 ) break loop19;
					EarlyExitException eee = new EarlyExitException(19, input);
					throw eee;
				}
				cnt19++;
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
	// ./src/VSLTreeParser.g:490:1: read_item[SymbolTable symTab] returns [Code3a code3a] : ( IDENT | array_elem[symTab] );
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT18=null;

		try {
			// ./src/VSLTreeParser.g:491:2: ( IDENT | array_elem[symTab] )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==IDENT) ) {
				alt20=1;
			}
			else if ( (LA20_0==ARELEM) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// ./src/VSLTreeParser.g:492:3: IDENT
					{
					IDENT18=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item1870); 

								code3a = Code3aGenerator.genReadIdent(symTab, (IDENT18!=null?IDENT18.getText():null), IDENT18);
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:499:3: array_elem[symTab]
					{
					pushFollow(FOLLOW_array_elem_in_read_item1883);
					array_elem(symTab);
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
	// $ANTLR end "read_item"



	// $ANTLR start "declaration"
	// ./src/VSLTreeParser.g:505:1: declaration[SymbolTable symTab] returns [Code3a code3a] : ^( DECL (value= decl_item[symTab] )+ ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a value =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:510:4: ( ^( DECL (value= decl_item[symTab] )+ ) )
			// ./src/VSLTreeParser.g:510:7: ^( DECL (value= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration1920); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:511:4: (value= decl_item[symTab] )+
			int cnt21=0;
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==IDENT||LA21_0==ARDECL) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// ./src/VSLTreeParser.g:511:5: value= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration1931);
					value=decl_item(symTab);
					state._fsp--;


					      				code3a.append(value);
					    			
					}
					break;

				default :
					if ( cnt21 >= 1 ) break loop21;
					EarlyExitException eee = new EarlyExitException(21, input);
					throw eee;
				}
				cnt21++;
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
	// ./src/VSLTreeParser.g:520:1: decl_item[SymbolTable symTab] returns [Code3a code3a] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT19=null;
		CommonTree IDENT20=null;
		CommonTree INTEGER21=null;
		CommonTree ARDECL22=null;


		     	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:525:4: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==IDENT) ) {
				alt22=1;
			}
			else if ( (LA22_0==ARDECL) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// ./src/VSLTreeParser.g:526:5: IDENT
					{
					IDENT19=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1993); 

								code3a.append(Code3aGenerator.genDeclVar(symTab, (IDENT19!=null?IDENT19.getText():null), IDENT19));
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:533:3: ^( ARDECL IDENT INTEGER )
					{
					ARDECL22=(CommonTree)match(input,ARDECL,FOLLOW_ARDECL_in_decl_item2014); 
					match(input, Token.DOWN, null); 
					IDENT20=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item2019); 
					INTEGER21=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item2024); 

									code3a.append(Code3aGenerator.genDeclArray(symTab, (IDENT20!=null?IDENT20.getText():null), Integer.parseInt((INTEGER21!=null?INTEGER21.getText():null)), ARDECL22));
								
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
	// $ANTLR end "decl_item"

	// Delegated rules



	public static final BitSet FOLLOW_program_in_s69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROG_in_program105 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_unit_in_program118 = new BitSet(new long[]{0x0000000008002008L});
	public static final BitSet FOLLOW_function_in_unit161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_proto_in_unit184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROTO_KW_in_proto221 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_proto228 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_proto234 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_param_list_in_proto241 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_KW_in_function276 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_function283 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_function289 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_param_list_in_function296 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_BODY_in_function314 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function322 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INT_KW_in_type363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KW_in_type374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARAM_in_param_list410 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list419 = new BitSet(new long[]{0x0000010000004008L});
	public static final BitSet FOLLOW_PARAM_in_param_list444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_param462 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_param480 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_param485 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement534 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement543 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement569 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_array_elem_in_statement631 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement687 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KW_in_statement718 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement728 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement750 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_statement_in_statement780 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement840 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement863 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement887 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement930 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_statement940 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_statement979 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_statement989 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_KW_in_statement1026 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement1036 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FCALL_S_in_statement1075 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_statement1083 = new BitSet(new long[]{0x0000108002C14208L});
	public static final BitSet FOLLOW_argument_list_in_statement1102 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block1160 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block1178 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block1183 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block1210 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block1214 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list1255 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list1264 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem1307 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem1313 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem1320 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expression1363 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1367 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1372 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression1403 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1407 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1412 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression1442 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1446 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1451 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression1481 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1485 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1490 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression1514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp1548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp1568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FCALL_in_primary_exp1598 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp1606 = new BitSet(new long[]{0x0000108002C14208L});
	public static final BitSet FOLLOW_argument_list_in_primary_exp1625 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_array_elem_in_primary_exp1666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_argument_list1706 = new BitSet(new long[]{0x0000108002C14202L});
	public static final BitSet FOLLOW_print_item_in_print_list1754 = new BitSet(new long[]{0x0000108202C14202L});
	public static final BitSet FOLLOW_TEXT_in_print_item1785 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item1800 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_item_in_read_list1839 = new BitSet(new long[]{0x0000008000004002L});
	public static final BitSet FOLLOW_IDENT_in_read_item1870 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_in_read_item1883 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECL_in_declaration1920 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration1931 = new BitSet(new long[]{0x0000004000004008L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1993 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item2014 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item2019 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item2024 = new BitSet(new long[]{0x0000000000000008L});
}
