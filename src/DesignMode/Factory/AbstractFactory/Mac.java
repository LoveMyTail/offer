package DesignMode.Factory.AbstractFactory;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Mac implements PC {
    @Override
    public void makePC() {
        System.out.println("建造一部苹果电脑");
    }
}
