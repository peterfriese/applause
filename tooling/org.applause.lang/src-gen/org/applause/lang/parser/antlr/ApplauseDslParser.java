/*
* generated by Xtext
*/
package org.applause.lang.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.applause.lang.services.ApplauseDslGrammarAccess;

public class ApplauseDslParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private ApplauseDslGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.applause.lang.parser.antlr.internal.InternalApplauseDslParser createParser(XtextTokenStream stream) {
		return new org.applause.lang.parser.antlr.internal.InternalApplauseDslParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}
	
	public ApplauseDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ApplauseDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
