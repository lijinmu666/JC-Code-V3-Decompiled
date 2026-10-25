package p094kotlin.p113reflect;

import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;

@SinceKotlin(m5061version = "1.1")
@Metadata(m4987d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001R\u0013\u0010\u0002\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u00020\fX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u00020\u0010X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015¨\u0006\u0012"}, m4988d2 = {"Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/KClassifier;", "name", BuildConfig.f24315FLAVOR, "getName", "()Ljava/lang/String;", "upperBounds", BuildConfig.f24315FLAVOR, "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "isReified", BuildConfig.f24315FLAVOR, "()Z", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.1"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface KTypeParameter extends KClassifier {
    /* renamed from: getName */
    String mo6348getName();

    List<InterfaceC1252KType> getUpperBounds();

    KVariance getVariance();

    boolean isReified();
}
