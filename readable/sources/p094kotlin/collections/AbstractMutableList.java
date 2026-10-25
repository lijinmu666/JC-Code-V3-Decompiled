package p094kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.internal.p106markers.KMutableList;

@SinceKotlin(m5061version = "1.1")
@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H§\u0082\bb\u0002\b\u000b¢\u0006\u0002\u0010\nJ\u001b\u0010\f\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH§\u0080\bb\u0002\b\u000b¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H¦\u0080\u0004¢\u0006\u0002\u0010\u0010Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¨\u0006\u0011"}, m4988d2 = {"Lkotlin/collections/AbstractMutableList;", "E", BuildConfig.f24315FLAVOR, "Ljava/util/AbstractList;", "<init>", "()V", "set", "index", BuildConfig.f24315FLAVOR, "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/IgnorableReturnValue;", "removeAt", "(I)Ljava/lang/Object;", "add", BuildConfig.f24315FLAVOR, "(ILjava/lang/Object;)V", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.1"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class AbstractMutableList<E> extends AbstractList<E> implements List<E>, KMutableList {
    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int index, E element);

    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    @IgnorableReturnValue
    public final /* bridge */ E remove(int i) {
        return removeAt(i);
    }

    @IgnorableReturnValue
    public abstract E removeAt(int index);

    @Override // java.util.AbstractList, java.util.List
    @IgnorableReturnValue
    public abstract E set(int index, E element);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
