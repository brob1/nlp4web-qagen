package candidate.extraction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Level;
import org.apache.uima.util.Logger;

import de.tudarmstadt.ukp.wikipedia.api.Category;
import de.tudarmstadt.ukp.wikipedia.api.Wikipedia;
import de.tudarmstadt.ukp.wikipedia.api.exception.WikiApiException;
import types.CandidateAnswer;
import types.CorrectAnswer;
import util.UimaListHandler;
import util.WikipediaFactory;

public class CandidateExtraction extends JCasAnnotator_ImplBase {

	private static final String LF = System.getProperty("line.separator");
	
	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		//FIXME: Removed DatabaseConfiguration dbconfig = DBConfig.getJwplDbConfig();
		Wikipedia wiki;
		Category cat;
		List<Integer> categories;
		Set<Integer> articles = new HashSet<Integer>();
		Logger logger = this.getContext().getLogger();
		CandidateAnswer candidate;
		StringBuilder sb;
		
		try {
			wiki = WikipediaFactory.getWikipedia(); // FIXME: Replaced  new Wikipedia(dbconfig);
			
			for (CorrectAnswer ca : JCasUtil.select(jcas, CorrectAnswer.class)) {
				categories = UimaListHandler.listToJavaIntegerList(ca.getMostRelevantCategories());
				
				for (int id : categories) {
					cat = wiki.getCategory(id);
					articles.addAll(this.getAllArticles(cat));
				}
				
				// Add candidate answer annotations
				sb = new StringBuilder();
				sb.append("Answer Candidates (");
				sb.append(articles.size());
				sb.append("): ");
				sb.append(LF);
				
				for (int articleid : articles) {
					candidate = new CandidateAnswer(jcas);
					candidate.setBegin(ca.getBegin());
					candidate.setEnd(ca.getEnd());
					candidate.setWikipediaPageId(articleid);
					candidate.addToIndexes();
					candidate.setTitle(wiki.getPage(articleid).getTitle().getPlainTitle());
				
					sb.append(articleid);
					// TODO remove due to performance considerations
					// sb.append(wiki.getPage(articleid).getTitle());
					
					sb.append(LF);
				}
				
				this.getContext().getLogger().log(Level.INFO, sb.toString());
			}
			
		} catch (WikiApiException e) {
			logger.log(Level.SEVERE, "Could not load articles form categories. Error: " + e.toString());
		}

	}
	
	/**
	 * Recursively find all articles of a category.
	 * @param cat The category.
	 * @return A set of article ids.
	 * @throws WikiApiException
	 */
	private Set<Integer> getAllArticles(Category cat) throws WikiApiException {
		Set<Integer> articles = new HashSet<Integer>();
		
		// Add articles of this category
		articles.addAll(cat.getArticleIds());
		
		// Add articles of all child categories
		if (cat.getNumberOfChildren() > 0) {
			for (Category c : cat.getChildren()) {
				articles.addAll(this.getAllArticles(c));
			}
		}
		
		return articles;
	}

}
