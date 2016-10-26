package com.lingjoin.classifier;

public class Classifier {

	public static boolean state=false;
	
	public static boolean init(String conf,String arg){
		state=CClassifierLibrary.instance.classifier_init(conf, arg, "0");
		if(state){
			return state;
		}else{
			System.out.println(CClassifierLibrary.instance.classifier_GetLastErrorMsg());
			return false;
		}
	}
	
	public static String classifier_exec(String sTitle,String sContent, int iType){
		if(state){
			return CClassifierLibrary.instance.classifier_exec(sTitle, sContent, iType);
		}else{
			System.out.println(CClassifierLibrary.instance.classifier_GetLastErrorMsg());
			return null;
		}
	}
	
	public static String classifier_detail(String classname){
		if(state){
			return CClassifierLibrary.instance.classifier_detail(classname);
		}else{
			System.out.println(CClassifierLibrary.instance.classifier_GetLastErrorMsg());
			return null;
		}
	}
	
	public static void exit(){
		CClassifierLibrary.instance.classifier_exit();
	}
}
