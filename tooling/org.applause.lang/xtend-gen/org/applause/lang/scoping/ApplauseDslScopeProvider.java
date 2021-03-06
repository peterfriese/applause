/**
 * generated by Xtext
 */
package org.applause.lang.scoping;

import java.util.Arrays;
import org.applause.lang.applauseDsl.Attribute;
import org.applause.lang.applauseDsl.DataSource;
import org.applause.lang.applauseDsl.DataSourceAccessMethod;
import org.applause.lang.applauseDsl.DataSourceCall;
import org.applause.lang.applauseDsl.DataType;
import org.applause.lang.applauseDsl.Entity;
import org.applause.lang.applauseDsl.EntityMemberCall;
import org.applause.lang.applauseDsl.ListItemCellDeclaration;
import org.applause.lang.applauseDsl.RESTMethodCall;
import org.applause.lang.applauseDsl.ScreenListItemCell;
import org.applause.lang.applauseDsl.Type;
import org.applause.lang.applauseDsl.UIComponentDeclaration;
import org.applause.lang.applauseDsl.UIComponentMemberCall;
import org.applause.lang.applauseDsl.UIComponentMemberDeclaration;
import org.applause.lang.applauseDsl.UIComponentOrDataType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping
 * on how and when to use it
 */
@SuppressWarnings("all")
public class ApplauseDslScopeProvider extends AbstractDeclarativeScopeProvider {
  public IScope scope_RESTMethodCall_restMethod(final RESTMethodCall ctx, final EReference ref) {
    DataSourceCall _datasource = ctx.getDatasource();
    DataSource _datasource_1 = _datasource.getDatasource();
    EList<DataSourceAccessMethod> _methods = _datasource_1.getMethods();
    IScope _scopeFor = Scopes.scopeFor(_methods);
    return _scopeFor;
  }
  
  public IScope scope_UIComponentMemberCall_component(final ScreenListItemCell ctx, final EReference ref) {
    ListItemCellDeclaration _type = ctx.getType();
    EList<UIComponentMemberDeclaration> _members = _type.getMembers();
    IScope _scopeFor = Scopes.scopeFor(_members);
    return _scopeFor;
  }
  
  public Object scope_UIComponentMemberCall_member(final UIComponentMemberCall ctx, final EReference ref) {
    Object _xblockexpression = null;
    {
      UIComponentMemberDeclaration _component = ctx.getComponent();
      final UIComponentOrDataType type = _component.getType();
      Object _membersScope = this.membersScope(type);
      _xblockexpression = (_membersScope);
    }
    return _xblockexpression;
  }
  
  private IScope _membersScope(final UIComponentDeclaration type) {
    EList<UIComponentMemberDeclaration> _members = type.getMembers();
    IScope _scopeFor = Scopes.scopeFor(_members);
    return _scopeFor;
  }
  
  private IScope _membersScope(final DataType type) {
    return null;
  }
  
  public Object scope_EntityMemberCall_head(final ScreenListItemCell ctx, final EReference ref) {
    Object _xblockexpression = null;
    {
      RESTMethodCall _restMethod = ctx.getRestMethod();
      DataSourceCall _datasource = _restMethod.getDatasource();
      DataSource _datasource_1 = _datasource.getDatasource();
      final Entity type = _datasource_1.getResourceType();
      Object _attributesScope = this.attributesScope(type);
      _xblockexpression = (_attributesScope);
    }
    return _xblockexpression;
  }
  
  public Object scope_EntityMemberCallTail_head(final EntityMemberCall ctx, final EReference ref) {
    Object _xblockexpression = null;
    {
      Attribute _head = ctx.getHead();
      final Type type = _head.getType();
      Object _attributesScope = this.attributesScope(type);
      _xblockexpression = (_attributesScope);
    }
    return _xblockexpression;
  }
  
  private IScope _attributesScope(final DataType type) {
    return null;
  }
  
  private IScope _attributesScope(final Entity entity) {
    EList<Attribute> _attributes = entity.getAttributes();
    IScope _scopeFor = Scopes.scopeFor(_attributes);
    return _scopeFor;
  }
  
  private Object membersScope(final EObject type) {
    if (type instanceof DataType) {
      return _membersScope((DataType)type);
    } else if (type instanceof UIComponentDeclaration) {
      return _membersScope((UIComponentDeclaration)type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
  
  private Object attributesScope(final Type type) {
    if (type instanceof DataType) {
      return _attributesScope((DataType)type);
    } else if (type instanceof Entity) {
      return _attributesScope((Entity)type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
}
