
/* First created by JCasGen Sun Feb 28 13:02:42 CET 2016 */
package de.unidu.langtech.pp.teaching.type;

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
 * Updated by JCasGen Sun Feb 28 13:03:22 CET 2016
 * @generated */
public class OpinionScore2_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (OpinionScore2_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = OpinionScore2_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new OpinionScore2(addr, OpinionScore2_Type.this);
  			   OpinionScore2_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new OpinionScore2(addr, OpinionScore2_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = OpinionScore2.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidu.langtech.pp.teaching.type.OpinionScore2");
 
  /** @generated */
  final Feature casFeat_opinionScore;
  /** @generated */
  final int     casFeatCode_opinionScore;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getOpinionScore(int addr) {
        if (featOkTst && casFeat_opinionScore == null)
      jcas.throwFeatMissing("opinionScore", "de.unidu.langtech.pp.teaching.type.OpinionScore2");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_opinionScore);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setOpinionScore(int addr, float v) {
        if (featOkTst && casFeat_opinionScore == null)
      jcas.throwFeatMissing("opinionScore", "de.unidu.langtech.pp.teaching.type.OpinionScore2");
    ll_cas.ll_setFloatValue(addr, casFeatCode_opinionScore, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public OpinionScore2_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_opinionScore = jcas.getRequiredFeatureDE(casType, "opinionScore", "uima.cas.Float", featOkTst);
    casFeatCode_opinionScore  = (null == casFeat_opinionScore) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_opinionScore).getCode();

  }
}



    