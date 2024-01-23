package com.deepfeed.qa.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyTransfermer implements IAnnotationTransformer {
	
public void transform(ITestAnnotation annotation, Class testclass, Constructor testconstructor,Method testMethod )
{
	//RetryAnalize this class where retry logic was written , 
	//i hv created earlier to use in test level 
	annotation.setRetryAnalyzer(RetryAnalize.class);
}
}
