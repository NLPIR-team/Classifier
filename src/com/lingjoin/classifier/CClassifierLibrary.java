package com.lingjoin.classifier;

import com.sun.jna.Native;

public interface CClassifierLibrary {

	CClassifierLibrary instance=(CClassifierLibrary) Native.loadLibrary("LJClassifier", CClassifierLibrary.class);
	
	/**
	 * @param conf "rulelist.xml"
	 * @return
	 */
	public boolean classifier_init(String conf,String sInitDirPath,String sLicenseCode);
	/** 功能：对输入的文章结构进行分类
	    参数：d:文章结构指针
	       iType=0:  输出类名，各类之间用\t隔开  内容格式举例：“要闻	敏感	诉讼”
	       iType=1:  输出类名和置信度，各类之间用\t隔开，类名和权重用“ ”隔开   内容格式举例：“要闻 1.00	敏感 0.95	诉讼 0.82”
	       iType 默认值为0
	    返回值：主题类别串  各类之间用\t隔开，类名按照置信度从高到低排序 
	**/
	public String classifier_exec(String sTitle,String sContent, int iType);
	
	/** 功能：对于当前文档，输入类名，取得结果明细
	    参数：classname:结果类名
	    返回值：结果明细 例如:
			   RULE3:
			   SUBRULE1: 内幕 1	
			   SUBRULE2: 股市 1	基金 3	股票 8	
			   SUBRULE3: 书摘 2	
    **/
	public String classifier_detail(String classname);
	
	public void classifier_exit();
	
	public String classifier_GetLastErrorMsg();
}
