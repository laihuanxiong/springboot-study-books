package com.study.books.homework.jvm.h1;


//@todo 建造者模式角色分类
//@todo 抽象建造者（builder）：描述具体建造者的公共接口，一般用来定义建造细节的方法，并不涉及具体的对象部件的创建。
//@todo 具体建造者（ConcreteBuilder）：描述具体建造者，并实现抽象建造者公共接口。
//@todo 指挥者（Director）：调用具体建造者来创建复杂对象（产品）的各个部分，并按照一定顺序（流程）来建造复杂对象。或者指挥者交给用户来操作，使得产品的创建更加简单灵活。就是Test中的main方法
//@todo 产品（Product）：描述一个由一系列部件组成较为复杂的对象。

/**
 * 建造者模式
 */
abstract class Builder {

    //汉堡
    abstract Builder buildeA(String mes);

    //饮料
    abstract Builder buildeB(String mes);

    //薯条
    abstract Builder buildeC(String mes);

    //甜品
    abstract Builder buildeD(String mes);

    //获取套餐
    abstract Product build();

}

class Product {
    private String buildA = "汉堡";
    private String buildB = "饮料";
    private String buildC = "薯条";
    private String buildD = "甜品";

    public String getBuildA() {
        return buildA;
    }

    public void setBuildA(String buildA) {
        this.buildA = buildA;
    }

    public String getBuildB() {
        return buildB;
    }

    public void setBuildB(String buildB) {
        this.buildB = buildB;
    }

    public String getBuildC() {
        return buildC;
    }

    public void setBuildC(String buildC) {
        this.buildC = buildC;
    }

    public String getBuildD() {
        return buildD;
    }

    public void setBuildD(String buildD) {
        this.buildD = buildD;
    }

    @Override
    public String toString() {
        return "Product{" +
                "buildA='" + buildA + '\'' +
                ", buildB='" + buildB + '\'' +
                ", buildC='" + buildC + '\'' +
                ", buildD='" + buildD + '\'' +
                '}';
    }
}

class ConcreteBuilder extends Builder {

    private Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    Builder buildeA(String mes) {
        product.setBuildA(mes);
        return this;
    }

    @Override
    Builder buildeB(String mes) {
        product.setBuildB(mes);
        return this;
    }

    @Override
    Builder buildeC(String mes) {
        product.setBuildC(mes);
        return this;
    }

    @Override
    Builder buildeD(String mes) {
        product.setBuildD(mes);
        return this;
    }

    @Override
    Product build() {
        return product;
    }
}

class Test {
    public static void main(String[] args) {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        Product product = concreteBuilder.buildeA("牛肉煲").buildeB("冰淇淋").build();
        System.out.println(product);
    }
}

