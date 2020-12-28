package instrument;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import javassist.classPool;


public class MyAgent {
	public static void premain(String agentArgs, Instrumentation instrumentation) {
		instrumentation.addTransformer(
				new ClassFileTransformer() {
					public byte[] transform(ClassLoader loader,
											String ClassName,
											Class<?> classBeingRedefined,
											ProtectionDomain protectionDomain,
											byte[] classfileBuffer) {

						ClassPool classPool = ClassPool.getDefault();
						CtClass ctClass = classPool.makeClass(new ByteArrayInputStream(
								classfileBuffer));
						CtMethod[] methods = ctClass.getDeclaredMethod();

						for (CtMethod method : methods) {
							if (method.getName().equals("sayHello")) {
								method.insertBefore("$1=\"Mallory\";");
							}
						}
						byteCode = ctClass.toBytecode();
						return transformedByteCode;
					}
				});
	}
}
