
/* First created by JCasGen Thu Jan 21 09:18:08 CET 2016 */
package types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Thu Jan 21 09:19:20 CET 2016
 * @generated */
public class CorrectAnswer_Type extends Answer_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (CorrectAnswer_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = CorrectAnswer_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new CorrectAnswer(addr, CorrectAnswer_Type.this);
  			   CorrectAnswer_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new CorrectAnswer(addr, CorrectAnswer_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = CorrectAnswer.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("types.CorrectAnswer");
 
  /** @generated */
  final Feature casFeat_mostRelevantCategories;
  /** @generated */
  final int     casFeatCode_mostRelevantCategories;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getMostRelevantCategories(int addr) {
        if (featOkTst && casFeat_mostRelevantCategories == null)
      jcas.throwFeatMissing("mostRelevantCategories", "types.CorrectAnswer");
    return ll_cas.ll_getRefValue(addr, casFeatCode_mostRelevantCategories);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setMostRelevantCategories(int addr, int v) {
        if (featOkTst && casFeat_mostRelevantCategories == null)
      jcas.throwFeatMissing("mostRelevantCategories", "types.CorrectAnswer");
    ll_cas.ll_setRefValue(addr, casFeatCode_mostRelevantCategories, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public CorrectAnswer_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_mostRelevantCategories = jcas.getRequiredFeatureDE(casType, "mostRelevantCategories", "uima.cas.NonEmptyIntegerList", featOkTst);
    casFeatCode_mostRelevantCategories  = (null == casFeat_mostRelevantCategories) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_mostRelevantCategories).getCode();

  }
}



    