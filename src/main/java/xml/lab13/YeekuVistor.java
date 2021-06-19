package xml.lab13;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.ProcessingInstruction;
import org.dom4j.VisitorSupport;

/**
 * Date: 2020/12/15 9:42
 */
public class YeekuVistor extends VisitorSupport {
    // 保存当前正在处理的节点
    private String currentElement;
    // 当Visitor访问元素时回调该方法
    public void visit(Element node) {
        // 如果节点内容全部是文本
        if (node.isTextOnly()) {
            System.out.println(node.getName() + "-->： " + node.getText());
        }
        currentElement = node.getName();
    }

    // 当Visitor访问属性时回调该方法
    public void visit(Attribute node) {
        System.out.println(currentElement + "元素的" + node.getName() + "属性的值为： "+ node.getText());
    }

    // 当Visitor访问处理指令时回调该方法
    @Override
    public void visit(ProcessingInstruction node) {
        System.out.println("处理指令" + node.getTarget() + "的内容为：" + node.getText());
    }
}
