package com.mjc813;

public class Main {
    public static void main(String[] args) {
        Variable01 var01 = new Variable01();
        var01.howToUseVariable();

        IntegerType intT = new IntegerType();
        CharType charT = new CharType();
        FDType fdT = new FDType();
        BooleanType boolT = new BooleanType();
        StringType strT = new StringType();

        intT.useInteger();
        charT.useChar();
        fdT.useFloatDouble();
        boolT.useBoolean();
        strT.useString();

        Castings cast = new Castings();
        cast.promotionExample();
        cast.castingExample();
        cast.operationPromotionExample();

        TranslateType translate = new TranslateType();
        translate.useTranslate();
        translate.useConversion();
    }
}