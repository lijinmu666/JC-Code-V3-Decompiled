package p131o;

import java.util.AbstractSet;
import java.util.Collection;

/* renamed from: o.SE */
/* loaded from: classes.dex */
public abstract class AbstractC2813SE extends AbstractSet {
    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        return AbstractC2944UE.m10479AZxh(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        collection.getClass();
        return super.retainAll(collection);
    }
}
