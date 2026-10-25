package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
/* loaded from: classes.dex */
@interface InlineMe {
    /* renamed from: imports */
    String[] m4030imports() default {};

    String replacement();

    String[] staticImports() default {};
}
