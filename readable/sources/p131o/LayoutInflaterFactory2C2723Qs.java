package p131o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.p022app.AbstractC0093KLFTb;
import androidx.fragment.p022app.Fragment;
import androidx.fragment.p022app.FragmentContainerView;

/* renamed from: o.Qs */
/* loaded from: classes.dex */
public class LayoutInflaterFactory2C2723Qs implements LayoutInflater.Factory2 {

    /* renamed from: mjFkc */
    public final AbstractC0093KLFTb f10290mjFkc;

    public LayoutInflaterFactory2C2723Qs(AbstractC0093KLFTb abstractC0093KLFTb) {
        this.f10290mjFkc = abstractC0093KLFTb;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f10290mjFkc);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3206Y4.f11794ZfxDd);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(AbstractC3206Y4.f11792KLFTb);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(AbstractC3206Y4.f11791JHa, -1);
        String string = typedArrayObtainStyledAttributes.getString(AbstractC3206Y4.f11799xJ);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !AbstractC3423bL.m11477AZxh(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentM926oCFDzJ = resourceId != -1 ? this.f10290mjFkc.m926oCFDzJ(resourceId) : null;
        if (fragmentM926oCFDzJ == null && string != null) {
            fragmentM926oCFDzJ = this.f10290mjFkc.m906aqHPIZ(string);
        }
        if (fragmentM926oCFDzJ == null && id != -1) {
            fragmentM926oCFDzJ = this.f10290mjFkc.m926oCFDzJ(id);
        }
        if (fragmentM926oCFDzJ == null) {
            Fragment fragmentMo951mjFkc = this.f10290mjFkc.m872JYgkl().mo951mjFkc(context.getClassLoader(), attributeValue);
            fragmentMo951mjFkc.f1126VA = true;
            if (resourceId == 0) {
                resourceId = id;
            }
            fragmentMo951mjFkc.f1134diqgf = resourceId;
            fragmentMo951mjFkc.f1135eyqo = id;
            fragmentMo951mjFkc.f1125Ucbh = string;
            fragmentMo951mjFkc.f1120MiMN = true;
            AbstractC0093KLFTb abstractC0093KLFTb = this.f10290mjFkc;
            fragmentMo951mjFkc.f1136fehf = abstractC0093KLFTb;
            abstractC0093KLFTb.m925nxI();
            this.f10290mjFkc.m925nxI();
            throw null;
        }
        if (!fragmentM926oCFDzJ.f1120MiMN) {
            fragmentM926oCFDzJ.f1120MiMN = true;
            AbstractC0093KLFTb abstractC0093KLFTb2 = this.f10290mjFkc;
            fragmentM926oCFDzJ.f1136fehf = abstractC0093KLFTb2;
            abstractC0093KLFTb2.m925nxI();
            this.f10290mjFkc.m925nxI();
            throw null;
        }
        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
    }
}
