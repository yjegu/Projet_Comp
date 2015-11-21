// $ANTLR 3.5 ./src/VSLTreeParser.g 2015-11-21 16:39:17

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
							if ( (LA4_0==IDENT) ) {
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
	// ./src/VSLTreeParser.g:126:1: param[SymbolTable symTab] returns [VarSymbol param] : IDENT ;
	public final VarSymbol param(SymbolTable symTab) throws RecognitionException {
		VarSymbol param = null;


		CommonTree IDENT5=null;

		try {
			// ./src/VSLTreeParser.g:127:2: ( IDENT )
			// ./src/VSLTreeParser.g:128:3: IDENT
			{
			IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param462); 

						param = Code3aGenerator.genParam(symTab, (IDENT5!=null?IDENT5.getText():null));
					
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
	// ./src/VSLTreeParser.g:136:1: statement[SymbolTable symTab] returns [Code3a code3a] : ( ^( ASSIGN_KW e1= expression[symTab] IDENT () ) |b= block[symTab] | ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pr= print_list[symTab] ) | ^( READ_KW r= read_list[symTab] ) | ^( RETURN_KW e= expression[symTab] ) | ^( FCALL_S IDENT (al= argument_list[symTab] )? ) );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT6=null;
		CommonTree ASSIGN_KW7=null;
		CommonTree IF_KW8=null;
		CommonTree RETURN_KW9=null;
		CommonTree IDENT10=null;
		CommonTree FCALL_S11=null;
		ExpAttribute e1 =null;
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
			// ./src/VSLTreeParser.g:141:4: ( ^( ASSIGN_KW e1= expression[symTab] IDENT () ) |b= block[symTab] | ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pr= print_list[symTab] ) | ^( READ_KW r= read_list[symTab] ) | ^( RETURN_KW e= expression[symTab] ) | ^( FCALL_S IDENT (al= argument_list[symTab] )? ) )
			int alt8=8;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt8=1;
				}
				break;
			case BLOCK:
				{
				alt8=2;
				}
				break;
			case IF_KW:
				{
				alt8=3;
				}
				break;
			case WHILE_KW:
				{
				alt8=4;
				}
				break;
			case PRINT_KW:
				{
				alt8=5;
				}
				break;
			case READ_KW:
				{
				alt8=6;
				}
				break;
			case RETURN_KW:
				{
				alt8=7;
				}
				break;
			case FCALL_S:
				{
				alt8=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// ./src/VSLTreeParser.g:142:5: ^( ASSIGN_KW e1= expression[symTab] IDENT () )
					{
					ASSIGN_KW7=(CommonTree)match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement509); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement513);
					e1=expression(symTab);
					state._fsp--;

					IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement516); 
					// ./src/VSLTreeParser.g:143:9: ()
					// ./src/VSLTreeParser.g:144:11: 
					{

					          			code3a = Code3aGenerator.genAffExpr(symTab, e1, (IDENT6!=null?IDENT6.getText():null), ASSIGN_KW7);
					        		
					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:152:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement571);
					b=block(symTab);
					state._fsp--;


					        	code3a = b;
					    	
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:159:6: ^( IF_KW e1= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					IF_KW8=(CommonTree)match(input,IF_KW,FOLLOW_IF_KW_in_statement602); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement612);
					e1=expression(symTab);
					state._fsp--;


					    			LabelSymbol l_else = SymbDistrib.newLabel();
					    			LabelSymbol l_end = SymbDistrib.newLabel();
					    			code3a = Code3aGenerator.genIfStatement(e1, l_else, IF_KW8);
					    		
					pushFollow(FOLLOW_statement_in_statement634);
					s1=statement(symTab);
					state._fsp--;


					    			code3a.append(s1);
					    			code3a.append(Code3aGenerator.genGoTo(l_end));
					    			code3a.append(Code3aGenerator.genLabel(l_else));
					    		
					// ./src/VSLTreeParser.g:174:7: (s2= statement[symTab] )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==ASSIGN_KW||LA6_0==IF_KW||LA6_0==PRINT_KW||(LA6_0 >= READ_KW && LA6_0 <= RETURN_KW)||LA6_0==WHILE_KW||LA6_0==BLOCK||LA6_0==FCALL_S) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// ./src/VSLTreeParser.g:175:8: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement664);
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
					// ./src/VSLTreeParser.g:187:7: ^( WHILE_KW e= expression[symTab] st= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement724); 

					          LabelSymbol l_while = SymbDistrib.newLabel();
					          LabelSymbol l_end = SymbDistrib.newLabel();
					        
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement747);
					e=expression(symTab);
					state._fsp--;


					          code3a = Code3aGenerator.genWhileStatement(e, l_end);
					        
					pushFollow(FOLLOW_statement_in_statement771);
					st=statement(symTab);
					state._fsp--;


					          code3a.append(st);
					          code3a.append(Code3aGenerator.genGoTo(l_while));
					        
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:208:6: ^( PRINT_KW pr= print_list[symTab] )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement814); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_print_list_in_statement824);
					pr=print_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					    		code3a = pr;
					    	
					}
					break;
				case 6 :
					// ./src/VSLTreeParser.g:218:6: ^( READ_KW r= read_list[symTab] )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement863); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_read_list_in_statement873);
					r=read_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        	code3a = r;
					    	
					}
					break;
				case 7 :
					// ./src/VSLTreeParser.g:227:6: ^( RETURN_KW e= expression[symTab] )
					{
					RETURN_KW9=(CommonTree)match(input,RETURN_KW,FOLLOW_RETURN_KW_in_statement910); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement920);
					e=expression(symTab);
					state._fsp--;


					    			code3a = Code3aGenerator.genReturn(e, RETURN_KW9);
					    		
					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// ./src/VSLTreeParser.g:237:6: ^( FCALL_S IDENT (al= argument_list[symTab] )? )
					{
					FCALL_S11=(CommonTree)match(input,FCALL_S,FOLLOW_FCALL_S_in_statement959); 
					match(input, Token.DOWN, null); 
					IDENT10=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement967); 
					// ./src/VSLTreeParser.g:240:7: (al= argument_list[symTab] )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==DIV||LA7_0==IDENT||LA7_0==INTEGER||(LA7_0 >= MINUS && LA7_0 <= MUL)||LA7_0==PLUS||LA7_0==FCALL) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// ./src/VSLTreeParser.g:241:8: al= argument_list[symTab]
							{
							pushFollow(FOLLOW_argument_list_in_statement986);
							al=argument_list(symTab);
							state._fsp--;

							}
							break;

					}


					    			code3a = Code3aGenerator.genFunctionCallInStatement(symTab, (IDENT10!=null?IDENT10.getText():null), (argument_list_return) al, FCALL_S11);
					    		
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
	// ./src/VSLTreeParser.g:250:1: block[SymbolTable symTab] returns [Code3a code3a] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a d =null;
		Code3a il =null;


		      code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:255:2: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==BLOCK) ) {
				int LA9_1 = input.LA(2);
				if ( (LA9_1==DOWN) ) {
					int LA9_2 = input.LA(3);
					if ( (LA9_2==DECL) ) {
						alt9=1;
					}
					else if ( (LA9_2==INST) ) {
						alt9=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 9, 2, input);
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
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// ./src/VSLTreeParser.g:256:3: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block1044); 

					      		symTab.enterScope();
					    	
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block1062);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block1067);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      		code3a = d;
					      		code3a.append(il);
					      		symTab.leaveScope();
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:271:4: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block1094); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block1098);
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
	// ./src/VSLTreeParser.g:278:1: inst_list[SymbolTable symTab] returns [Code3a code3a] : ^( INST (il= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a il =null;


		      	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:283:4: ( ^( INST (il= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:284:5: ^( INST (il= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list1150); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:285:10: (il= statement[symTab] )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==ASSIGN_KW||LA10_0==IF_KW||LA10_0==PRINT_KW||(LA10_0 >= READ_KW && LA10_0 <= RETURN_KW)||LA10_0==WHILE_KW||LA10_0==BLOCK||LA10_0==FCALL_S) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// ./src/VSLTreeParser.g:286:10: il= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list1164);
					il=statement(symTab);
					state._fsp--;


					        			code3a.append(il);
					      			
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
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
	// ./src/VSLTreeParser.g:295:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// ./src/VSLTreeParser.g:296:4: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt11=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt11=1;
				}
				break;
			case MINUS:
				{
				alt11=2;
				}
				break;
			case MUL:
				{
				alt11=3;
				}
				break;
			case DIV:
				{
				alt11=4;
				}
				break;
			case IDENT:
			case INTEGER:
			case FCALL:
				{
				alt11=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// ./src/VSLTreeParser.g:298:6: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression1225); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1229);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1234);
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
					// ./src/VSLTreeParser.g:309:6: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression1265); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1269);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1274);
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
					// ./src/VSLTreeParser.g:320:6: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression1304); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1308);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1313);
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
					// ./src/VSLTreeParser.g:331:6: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression1343); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1347);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1352);
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
					// ./src/VSLTreeParser.g:341:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression1376);
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
	// ./src/VSLTreeParser.g:349:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT | ^( FCALL IDENT (al= argument_list[symTab] )? ) );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER12=null;
		CommonTree IDENT13=null;
		CommonTree IDENT14=null;
		CommonTree FCALL15=null;
		TreeRuleReturnScope al =null;

		try {
			// ./src/VSLTreeParser.g:350:4: ( INTEGER | IDENT | ^( FCALL IDENT (al= argument_list[symTab] )? ) )
			int alt13=3;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt13=1;
				}
				break;
			case IDENT:
				{
				alt13=2;
				}
				break;
			case FCALL:
				{
				alt13=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// ./src/VSLTreeParser.g:351:5: INTEGER
					{
					INTEGER12=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp1410); 

					      		ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER12!=null?INTEGER12.getText():null)));
					      		expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:359:5: IDENT
					{
					IDENT13=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp1430); 

					      		Operand3a id = symTab.lookup((IDENT13!=null?IDENT13.getText():null));
					      		if(id == null) {
					      			Errors.unknownIdentifier(IDENT13, (IDENT13!=null?IDENT13.getText():null), null);
					      			System.err.println("Compilation terminated");
					      			System.exit(-1);
					      		}
					      		expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT13!=null?IDENT13.getText():null)));
					    	
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:372:6: ^( FCALL IDENT (al= argument_list[symTab] )? )
					{
					FCALL15=(CommonTree)match(input,FCALL,FOLLOW_FCALL_in_primary_exp1460); 
					match(input, Token.DOWN, null); 
					IDENT14=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp1468); 
					// ./src/VSLTreeParser.g:375:7: (al= argument_list[symTab] )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==DIV||LA12_0==IDENT||LA12_0==INTEGER||(LA12_0 >= MINUS && LA12_0 <= MUL)||LA12_0==PLUS||LA12_0==FCALL) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// ./src/VSLTreeParser.g:376:8: al= argument_list[symTab]
							{
							pushFollow(FOLLOW_argument_list_in_primary_exp1487);
							al=argument_list(symTab);
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					    		expAtt = Code3aGenerator.genFunctionCallInPrimaryExp(symTab, (IDENT14!=null?IDENT14.getText():null), (argument_list_return) al, FCALL15);
					    	
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
	// ./src/VSLTreeParser.g:384:1: argument_list[SymbolTable symTab] returns [Code3a code, List<Type> args] : (e= expression[symTab] )+ ;
	public final VSLTreeParser.argument_list_return argument_list(SymbolTable symTab) throws RecognitionException {
		VSLTreeParser.argument_list_return retval = new VSLTreeParser.argument_list_return();
		retval.start = input.LT(1);

		ExpAttribute e =null;


				retval.code = new Code3a();
				retval.args = new ArrayList<Type>();
			
		try {
			// ./src/VSLTreeParser.g:390:2: ( (e= expression[symTab] )+ )
			// ./src/VSLTreeParser.g:391:3: (e= expression[symTab] )+
			{
			// ./src/VSLTreeParser.g:391:3: (e= expression[symTab] )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==DIV||LA14_0==IDENT||LA14_0==INTEGER||(LA14_0 >= MINUS && LA14_0 <= MUL)||LA14_0==PLUS||LA14_0==FCALL) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// ./src/VSLTreeParser.g:392:4: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_argument_list1543);
					e=expression(symTab);
					state._fsp--;


									retval.args.add(e.type);
									retval.code.append(e.code);
									retval.code.append(Code3aGenerator.genArg(e.place));
								
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
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
	// ./src/VSLTreeParser.g:402:1: print_list[SymbolTable symTab] returns [Code3a code3a] : (pr_list= print_item[symTab] )+ ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a pr_list =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:407:2: ( (pr_list= print_item[symTab] )+ )
			// ./src/VSLTreeParser.g:408:3: (pr_list= print_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:408:3: (pr_list= print_item[symTab] )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==DIV||LA15_0==IDENT||LA15_0==INTEGER||(LA15_0 >= MINUS && LA15_0 <= MUL)||LA15_0==PLUS||LA15_0==TEXT||LA15_0==FCALL) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// ./src/VSLTreeParser.g:409:4: pr_list= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list1591);
					pr_list=print_item(symTab);
					state._fsp--;


									code3a.append(pr_list);
								
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
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
	// ./src/VSLTreeParser.g:417:1: print_item[SymbolTable symTab] returns [Code3a code3a] : ( TEXT |e= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree TEXT16=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:418:2: ( TEXT |e= expression[symTab] )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==TEXT) ) {
				alt16=1;
			}
			else if ( (LA16_0==DIV||LA16_0==IDENT||LA16_0==INTEGER||(LA16_0 >= MINUS && LA16_0 <= MUL)||LA16_0==PLUS||LA16_0==FCALL) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// ./src/VSLTreeParser.g:419:3: TEXT
					{
					TEXT16=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item1622); 

								code3a = Code3aGenerator.genPrintString((TEXT16!=null?TEXT16.getText():null));	
							
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:426:3: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item1637);
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
	// ./src/VSLTreeParser.g:433:1: read_list[SymbolTable symTab] returns [Code3a code3a] : (rl= read_item[symTab] )+ ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a rl =null;


				code3a = new Code3a();
			
		try {
			// ./src/VSLTreeParser.g:438:2: ( (rl= read_item[symTab] )+ )
			// ./src/VSLTreeParser.g:439:3: (rl= read_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:439:3: (rl= read_item[symTab] )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==IDENT) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// ./src/VSLTreeParser.g:440:4: rl= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list1676);
					rl=read_item(symTab);
					state._fsp--;


									code3a.append(rl);
								
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
	// $ANTLR end "read_list"



	// $ANTLR start "read_item"
	// ./src/VSLTreeParser.g:448:1: read_item[SymbolTable symTab] returns [Code3a code3a] : IDENT ;
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT17=null;

		try {
			// ./src/VSLTreeParser.g:449:2: ( IDENT )
			// ./src/VSLTreeParser.g:450:3: IDENT
			{
			IDENT17=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item1707); 

						code3a = Code3aGenerator.genReadIdent(symTab, (IDENT17!=null?IDENT17.getText():null), IDENT17);
					
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
	// ./src/VSLTreeParser.g:459:1: declaration[SymbolTable symTab] returns [Code3a code3a] : ^( DECL (value= decl_item[symTab] )+ ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		Code3a value =null;


		    	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:464:4: ( ^( DECL (value= decl_item[symTab] )+ ) )
			// ./src/VSLTreeParser.g:464:7: ^( DECL (value= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration1747); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:465:4: (value= decl_item[symTab] )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==IDENT) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// ./src/VSLTreeParser.g:465:5: value= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration1758);
					value=decl_item(symTab);
					state._fsp--;


					      				code3a.append(value);
					    			
					}
					break;

				default :
					if ( cnt18 >= 1 ) break loop18;
					EarlyExitException eee = new EarlyExitException(18, input);
					throw eee;
				}
				cnt18++;
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
	// ./src/VSLTreeParser.g:474:1: decl_item[SymbolTable symTab] returns [Code3a code3a] : IDENT ;
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code3a = null;


		CommonTree IDENT18=null;


		     	code3a = new Code3a();
		    
		try {
			// ./src/VSLTreeParser.g:479:4: ( IDENT )
			// ./src/VSLTreeParser.g:480:5: IDENT
			{
			IDENT18=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1820); 

						code3a.append(Code3aGenerator.genDeclVar(symTab, (IDENT18!=null?IDENT18.getText():null)));
					
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
	public static final BitSet FOLLOW_param_in_param_list419 = new BitSet(new long[]{0x0000000000004008L});
	public static final BitSet FOLLOW_PARAM_in_param_list444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_param462 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement509 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement513 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement516 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement571 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KW_in_statement602 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement612 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement634 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_statement_in_statement664 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement724 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement747 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement771 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement814 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_statement824 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_statement863 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_statement873 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_KW_in_statement910 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement920 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FCALL_S_in_statement959 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_statement967 = new BitSet(new long[]{0x0000100002C14208L});
	public static final BitSet FOLLOW_argument_list_in_statement986 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block1044 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block1062 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block1067 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block1094 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block1098 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list1150 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list1164 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_PLUS_in_expression1225 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1229 = new BitSet(new long[]{0x0000100002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1234 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression1265 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1269 = new BitSet(new long[]{0x0000100002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1274 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression1304 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1308 = new BitSet(new long[]{0x0000100002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1313 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression1343 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1347 = new BitSet(new long[]{0x0000100002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1352 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression1376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp1410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp1430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FCALL_in_primary_exp1460 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp1468 = new BitSet(new long[]{0x0000100002C14208L});
	public static final BitSet FOLLOW_argument_list_in_primary_exp1487 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_expression_in_argument_list1543 = new BitSet(new long[]{0x0000100002C14202L});
	public static final BitSet FOLLOW_print_item_in_print_list1591 = new BitSet(new long[]{0x0000100202C14202L});
	public static final BitSet FOLLOW_TEXT_in_print_item1622 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item1637 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_item_in_read_list1676 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_IDENT_in_read_item1707 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECL_in_declaration1747 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration1758 = new BitSet(new long[]{0x0000000000004008L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1820 = new BitSet(new long[]{0x0000000000000002L});
}
