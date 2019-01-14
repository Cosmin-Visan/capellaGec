/**
 * 
 *   Copyright (c) 2006, 2019 THALES DMS FRANCE.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Thales - initial API and implementation
 *  
 */
package org.polarsys.capella.viatra.core.data.information.communication.surrogate;

import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.polarsys.capella.core.data.information.communication.CommunicationLink;
import org.polarsys.capella.core.data.information.communication.CommunicationLinkExchanger;
import org.polarsys.capella.viatra.core.data.information.communication.surrogate.util.CommunicationLinkExchanger__transmitQuerySpecification;

/**
 * Pattern-specific match representation of the org.polarsys.capella.viatra.core.data.information.communication.surrogate.CommunicationLinkExchanger__transmit pattern,
 * to be used in conjunction with {@link CommunicationLinkExchanger__transmitMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see CommunicationLinkExchanger__transmitMatcher
 * @see CommunicationLinkExchanger__transmitProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class CommunicationLinkExchanger__transmitMatch extends BasePatternMatch {
  private CommunicationLinkExchanger fSelf;
  
  private CommunicationLink fTarget;
  
  private static List<String> parameterNames = makeImmutableList("self", "target");
  
  private CommunicationLinkExchanger__transmitMatch(final CommunicationLinkExchanger pSelf, final CommunicationLink pTarget) {
    this.fSelf = pSelf;
    this.fTarget = pTarget;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("self".equals(parameterName)) return this.fSelf;
    if ("target".equals(parameterName)) return this.fTarget;
    return null;
  }
  
  public CommunicationLinkExchanger getSelf() {
    return this.fSelf;
  }
  
  public CommunicationLink getTarget() {
    return this.fTarget;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("self".equals(parameterName) ) {
        this.fSelf = (CommunicationLinkExchanger) newValue;
        return true;
    }
    if ("target".equals(parameterName) ) {
        this.fTarget = (CommunicationLink) newValue;
        return true;
    }
    return false;
  }
  
  public void setSelf(final CommunicationLinkExchanger pSelf) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSelf = pSelf;
  }
  
  public void setTarget(final CommunicationLink pTarget) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTarget = pTarget;
  }
  
  @Override
  public String patternName() {
    return "org.polarsys.capella.viatra.core.data.information.communication.surrogate.CommunicationLinkExchanger__transmit";
  }
  
  @Override
  public List<String> parameterNames() {
    return CommunicationLinkExchanger__transmitMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSelf, fTarget};
  }
  
  @Override
  public CommunicationLinkExchanger__transmitMatch toImmutable() {
    return isMutable() ? newMatch(fSelf, fTarget) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"self\"=" + prettyPrintValue(fSelf) + ", ");
    
    result.append("\"target\"=" + prettyPrintValue(fTarget)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSelf == null) ? 0 : fSelf.hashCode());
    result = prime * result + ((fTarget == null) ? 0 : fTarget.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof CommunicationLinkExchanger__transmitMatch)) { // this should be infrequent
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof IPatternMatch)) {
            return false;
        }
        IPatternMatch otherSig  = (IPatternMatch) obj;
        if (!specification().equals(otherSig.specification()))
            return false;
        return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    CommunicationLinkExchanger__transmitMatch other = (CommunicationLinkExchanger__transmitMatch) obj;
    if (fSelf == null) {if (other.fSelf != null) return false;}
    else if (!fSelf.equals(other.fSelf)) return false;
    if (fTarget == null) {if (other.fTarget != null) return false;}
    else if (!fTarget.equals(other.fTarget)) return false;
    return true;
  }
  
  @Override
  public CommunicationLinkExchanger__transmitQuerySpecification specification() {
    try {
        return CommunicationLinkExchanger__transmitQuerySpecification.instance();
    } catch (ViatraQueryException ex) {
         // This cannot happen, as the match object can only be instantiated if the query specification exists
         throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static CommunicationLinkExchanger__transmitMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSelf the fixed value of pattern parameter self, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static CommunicationLinkExchanger__transmitMatch newMutableMatch(final CommunicationLinkExchanger pSelf, final CommunicationLink pTarget) {
    return new Mutable(pSelf, pTarget);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSelf the fixed value of pattern parameter self, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static CommunicationLinkExchanger__transmitMatch newMatch(final CommunicationLinkExchanger pSelf, final CommunicationLink pTarget) {
    return new Immutable(pSelf, pTarget);
  }
  
  private static final class Mutable extends CommunicationLinkExchanger__transmitMatch {
    Mutable(final CommunicationLinkExchanger pSelf, final CommunicationLink pTarget) {
      super(pSelf, pTarget);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends CommunicationLinkExchanger__transmitMatch {
    Immutable(final CommunicationLinkExchanger pSelf, final CommunicationLink pTarget) {
      super(pSelf, pTarget);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
