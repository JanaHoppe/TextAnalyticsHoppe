
/* First created by JCasGen Thu Jan 07 21:16:38 CET 2016 */
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
 * Updated by JCasGen Thu Jan 07 21:16:38 CET 2016
 * @generated */
public class OpinionFinding_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (OpinionFinding_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = OpinionFinding_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new OpinionFinding(addr, OpinionFinding_Type.this);
  			   OpinionFinding_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new OpinionFinding(addr, OpinionFinding_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = OpinionFinding.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidu.langtech.pp.teaching.type.OpinionFinding");
 
  /** @generated */
  final Feature casFeat_opinionFound;
  /** @generated */
  final int     casFeatCode_opinionFound;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getOpinionFound(int addr) {
        if (featOkTst && casFeat_opinionFound == null)
      jcas.throwFeatMissing("opinionFound", "de.unidu.langtech.pp.teaching.type.OpinionFinding");
    return ll_cas.ll_getStringValue(addr, casFeatCode_opinionFound);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setOpinionFound(int addr, String v) {
        if (featOkTst && casFeat_opinionFound == null)
      jcas.throwFeatMissing("opinionFound", "de.unidu.langtech.pp.teaching.type.OpinionFinding");
    ll_cas.ll_setStringValue(addr, casFeatCode_opinionFound, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public OpinionFinding_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_opinionFound = jcas.getRequiredFeatureDE(casType, "opinionFound", "uima.cas.String", featOkTst);
    casFeatCode_opinionFound  = (null == casFeat_opinionFound) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_opinionFound).getCode();

  }
}



    