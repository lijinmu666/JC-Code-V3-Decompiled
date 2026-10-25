package org.bouncycastle.p310pkix.p311jcajce;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class PKIXPolicyNode implements PolicyNode {
    protected List children;
    protected boolean critical;

    /* renamed from: depth */
    protected int f22986depth;
    protected Set expectedPolicies;

    /* renamed from: parent */
    protected PolicyNode f22987parent;
    protected Set policyQualifiers;
    protected String validPolicy;

    public PKIXPolicyNode(List list, int i, Set set, PolicyNode policyNode, Set set2, String str, boolean z) {
        this.children = list;
        this.f22986depth = i;
        this.expectedPolicies = set;
        this.f22987parent = policyNode;
        this.policyQualifiers = set2;
        this.validPolicy = str;
        this.critical = z;
    }

    public void addChild(PKIXPolicyNode pKIXPolicyNode) {
        this.children.add(pKIXPolicyNode);
        pKIXPolicyNode.setParent(this);
    }

    /* renamed from: clone */
    public Object m17444clone() {
        return m17445copy();
    }

    /* renamed from: copy */
    public PKIXPolicyNode m17445copy() {
        HashSet hashSet = new HashSet();
        Iterator it = this.expectedPolicies.iterator();
        while (it.hasNext()) {
            hashSet.add(new String((String) it.next()));
        }
        HashSet hashSet2 = new HashSet();
        Iterator it2 = this.policyQualifiers.iterator();
        while (it2.hasNext()) {
            hashSet2.add(new String((String) it2.next()));
        }
        PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), this.f22986depth, hashSet, null, hashSet2, new String(this.validPolicy), this.critical);
        Iterator it3 = this.children.iterator();
        while (it3.hasNext()) {
            PKIXPolicyNode pKIXPolicyNodeM17445copy = ((PKIXPolicyNode) it3.next()).m17445copy();
            pKIXPolicyNodeM17445copy.setParent(pKIXPolicyNode);
            pKIXPolicyNode.addChild(pKIXPolicyNodeM17445copy);
        }
        return pKIXPolicyNode;
    }

    @Override // java.security.cert.PolicyNode
    public Iterator getChildren() {
        return this.children.iterator();
    }

    @Override // java.security.cert.PolicyNode
    public int getDepth() {
        return this.f22986depth;
    }

    @Override // java.security.cert.PolicyNode
    public Set getExpectedPolicies() {
        return this.expectedPolicies;
    }

    @Override // java.security.cert.PolicyNode
    public PolicyNode getParent() {
        return this.f22987parent;
    }

    @Override // java.security.cert.PolicyNode
    public Set getPolicyQualifiers() {
        return this.policyQualifiers;
    }

    @Override // java.security.cert.PolicyNode
    public String getValidPolicy() {
        return this.validPolicy;
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    @Override // java.security.cert.PolicyNode
    public boolean isCritical() {
        return this.critical;
    }

    public void removeChild(PKIXPolicyNode pKIXPolicyNode) {
        this.children.remove(pKIXPolicyNode);
    }

    public void setCritical(boolean z) {
        this.critical = z;
    }

    public void setExpectedPolicies(Set set) {
        this.expectedPolicies = set;
    }

    public void setParent(PKIXPolicyNode pKIXPolicyNode) {
        this.f22987parent = pKIXPolicyNode;
    }

    public String toString() {
        return toString(BuildConfig.f24315FLAVOR);
    }

    public String toString(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(this.validPolicy);
        stringBuffer.append(" {\n");
        for (int i = 0; i < this.children.size(); i++) {
            stringBuffer.append(((PKIXPolicyNode) this.children.get(i)).toString(str + "    "));
        }
        stringBuffer.append(str);
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }
}
