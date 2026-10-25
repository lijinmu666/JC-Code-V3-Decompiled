package p094kotlin.p113reflect;

import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;

@Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R+\u0010\u0002\u001a\u0004\u0018\u00010\u00038&X§\u0084\br\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R/\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8&X§\u0084\br\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u00020\u0012X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, m4988d2 = {"Lkotlin/reflect/KType;", "Lkotlin/reflect/KAnnotatedElement;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier$annotations", "()V", "getClassifier", "()Lkotlin/reflect/KClassifier;", "Lkotlin/SinceKotlin;", "version", "1.1", "arguments", BuildConfig.f24315FLAVOR, "Lkotlin/reflect/KTypeProjection;", "getArguments$annotations", "getArguments", "()Ljava/util/List;", "isMarkedNullable", BuildConfig.f24315FLAVOR, "()Z", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* renamed from: kotlin.reflect.KType */
/* loaded from: classes.dex */
public interface InterfaceC1252KType extends KAnnotatedElement {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.reflect.KType$DefaultImpls */
    public static final class DefaultImpls {
        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void getArguments$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void getClassifier$annotations() {
        }
    }

    List<KTypeProjection> getArguments();

    KClassifier getClassifier();

    boolean isMarkedNullable();
}
