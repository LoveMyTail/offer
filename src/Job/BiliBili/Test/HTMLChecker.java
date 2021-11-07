package Job.BiliBili.Test;

/**
 * 实现一个HTML语法检查器。HTML语法规则简化如下：标签必须闭合，可以由开始和结束两个标签闭合，如<div></div>，
 * 也可以自闭合，如<div />
 * 标签可以嵌套如<div><a></a></div>或者 <div><a/></div>，但是标签不能交叉：<div><a></div></a>
 * 是不允许的标签里可以有属性如<div id="a<1"></div>
 * 属性的规则是name="任意非引号字符"，多属性声明之间必须有空格，属性声明不符合规则时，整段HTML都算语法错误
 * 输入文本只会出现字母a-z和<>"=
 * 请用任意语言实现一个HTML语法检查器函数，有语法错误返回1，没有语法错误返回0
 * weird
 */
public class HTMLChecker {
    public static void main(String[] args) {

    }
}
