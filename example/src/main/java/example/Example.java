package example;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import javassist.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example {
    public static void main(String[] args) {
        // Userクラス使ってみる
        User user = new User("pochi", 5, 80.0f, 80.0f);
        System.out.println(user.getUserInfo());

        // Userクラスをパースする
        SampleJavaParser();

        // Userクラスを弄る
        // 参照: https://qiita.com/hiroki19990625/items/f51dda992bd0bb90b3ac
        try {
            ClassPool pool = ClassPool.getDefault();

            CtClass ctc = pool.get("example.User");

            CtField field = new CtField(CtClass.intType, "money", ctc);
        } catch(NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }

    private static void SampleJavaParser() {
        Path source = Paths.get("src/main/java/example/User.java");
        try {
            CompilationUnit unit = JavaParser.parse(source);
            System.out.println("***********************************************");
            System.out.println(unit);
            System.out.println("***********************************************");
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}