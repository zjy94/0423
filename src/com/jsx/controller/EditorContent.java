package com.booway.ego.render;

import java.io.IOException;

import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.IntegerConverter;
import javax.servlet.http.HttpServletRequest;

import org.apache.myfaces.renderkit.html.util.AddResource;
import org.apache.myfaces.renderkit.html.util.AddResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FacesComponent("com.ego.EditorContent")
public class EditorContent extends UIInput {
	private static final Logger LOG = LoggerFactory.getLogger(EditorContent.class);
	private String _pageId = null;
	private String _contentVar = null;
	private String _urlPattern = null;
	private String _styleClass = null;
	private String _id = null;

	private String resourceJquery = "true";
	private String resourceBootStrap = "true";
	private String resourceAngularJs = "true";
	private String angulaApp = "true";

	private String onCreateEditor = "";
	private String beforeCreateEditor = "";
	private String onContentChange = "";
	private String onSelectionChange = "";

	private String simpleModel = "false";//
	private String simpleList = "";// 精简模式的显示操作列表，需要通过注册才能实现
	private String accpetMacroList = "";// 接受的宏管理名称列表
	private String rejectMacroList = "";// 拒绝的宏管理名称列表

	public EditorContent() throws IOException {
		setConverter(new IntegerConverter()); // to convert the submitted value
		setRendererType(null); // this component renders itself
	}

	public void encodeBegin(FacesContext context) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		AddResource addResource = AddResourceFactory.getInstance(context);
		// addResource.addStyleSheet(context, AddResource.BODY_END,
		// "/javax.faces.resource/prev.css.xhtml?ln=public");
		addResource.addJavaScriptAtPosition(context, AddResource.HEADER_BEGIN,
				"/javax.faces.resource/kbcommon.js.xhtml?ln=public");
		EditorHtml html = EditorHtmlFactory.getHtml();
		html.setContextPath(context.getExternalContext().getRequestContextPath());
		html.setContentVar(getContentVar());
		html.setId(getId());
		html.setPageId(getPageId());
		html.setPath(((HttpServletRequest) context.getExternalContext().getRequest()).getContextPath());
		// System.out.println("当前的PageId"+getPageId());
		html.setStyleClass(getStyleClass());
		html.setUrlPattern(getUrlPattern());
		html.setResourceJquery(getResourceJquery());
		html.setResourceBootStrap(getResourceBootStrap());
		html.setResourceAngularJs(getResourceAngularJs());
		html.setAngulaApp(getAngulaApp());
		html.setOnContentChange(getOnContentChange());
		html.setOnCreateEditor(getOnCreateEditor());
		html.setOnSelectionChange(getOnSelectionChange());
		html.setBeforeCreateEditor(getBeforeCreateEditor());
		writer.append(html.getAttrHtml());
		// writer.append("测试数据2");

	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		// TODO Auto-generated method stub
		AddResource addResource = AddResourceFactory.getInstance(context);
		// addResource.addStyleSheet(context, AddResource.BODY_END,
		// "/javax.faces.resource/prev.css.xhtml?ln=public");
		addResource.addJavaScriptAtPosition(context, AddResource.HEADER_BEGIN,
				"/javax.faces.resource/kbcommon.js.xhtml?ln=public");
		super.encodeEnd(context);
	}

	public void decode(FacesContext context) {
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		String content = request.getParameter("design_content");
		LOG.info("内容：", content);
		setContentVar(content);
	}

	public String getPageId() {
		if (_pageId != null) {
			return _pageId;
		}
		ValueExpression vb = getValueExpression("pageId");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setPageId(String pageId) {
		this._pageId = pageId;
	}

	public String getContentVar() {
		if (_contentVar != null) {
			return _contentVar;
		}
		ValueExpression vb = getValueExpression("contentVar");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setContentVar(String contentVar) {
		this._contentVar = contentVar;
	}

	public String getUrlPattern() {
		if (_urlPattern != null) {
			return _urlPattern;
		}
		ValueExpression vb = getValueExpression("urlPattern");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setUrlPattern(String urlPattern) {
		this._urlPattern = urlPattern;
	}

	public String getStyleClass() {

		if (_styleClass != null) {
			return _styleClass;
		}
		ValueExpression vb = getValueExpression("styleClass");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setStyleClass(String styleClass) {
		this._styleClass = styleClass;
	}

	public String getId() {

		if (_id != null) {
			return _id;
		}
		ValueExpression vb = getValueExpression("id");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setId(String id) {
		this._id = id;
	}

	public String getResourceJquery() {
		if (resourceJquery != null) {
			return resourceJquery;
		}
		ValueExpression vb = getValueExpression("resourceJquery");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setResourceJquery(String resourceJquery) {
		this.resourceJquery = resourceJquery;
	}

	public String getResourceBootStrap() {
		if (resourceBootStrap != null) {
			return resourceBootStrap;
		}
		ValueExpression vb = getValueExpression("resourceBootStrap");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setResourceBootStrap(String resourceBootStrap) {
		this.resourceBootStrap = resourceBootStrap;
	}

	public String getResourceAngularJs() {
		if (resourceAngularJs != null) {
			return resourceAngularJs;
		}
		ValueExpression vb = getValueExpression("resourceAngularJs");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setResourceAngularJs(String resourceAngularJs) {
		this.resourceAngularJs = resourceAngularJs;
	}

	public String getAngulaApp() {
		if (angulaApp != null) {
			return angulaApp;
		}
		ValueExpression vb = getValueExpression("angulaApp");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setAngulaApp(String angulaApp) {
		this.angulaApp = angulaApp;
	}

	public String getOnCreateEditor() {
		if (onCreateEditor != null) {
			return onCreateEditor;
		}
		ValueExpression vb = getValueExpression("onCreateEditor");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setOnCreateEditor(String onCreateEditor) {
		this.onCreateEditor = onCreateEditor;
	}

	public String getBeforeCreateEditor() {
		if (beforeCreateEditor != null) {
			return beforeCreateEditor;
		}
		ValueExpression vb = getValueExpression("beforeCreateEditor");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setBeforeCreateEditor(String beforeCreateEditor) {
		this.beforeCreateEditor = beforeCreateEditor;
	}

	public String getOnContentChange() {
		if (onContentChange != null) {
			return onContentChange;
		}
		ValueExpression vb = getValueExpression("onContentChange");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setOnContentChange(String onContentChange) {
		this.onContentChange = onContentChange;
	}

	public String getOnSelectionChange() {
		if (onSelectionChange != null) {
			return onSelectionChange;
		}
		ValueExpression vb = getValueExpression("onSelectionChange");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setOnSelectionChange(String onSelectionChange) {
		this.onSelectionChange = onSelectionChange;
	}

	public String getSimpleModel() {
		if (simpleModel != null) {
			return simpleModel;
		}
		ValueExpression vb = getValueExpression("simpleModel");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setSimpleModel(String simpleModel) {
		this.simpleModel = simpleModel;
	}

	public String getSimpleList() {
		if (simpleList != null) {
			return simpleList;
		}
		ValueExpression vb = getValueExpression("simpleList");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setSimpleList(String simpleList) {
		this.simpleList = simpleList;
	}

	public String getAccpetMacroList() {
		if (accpetMacroList != null) {
			return accpetMacroList;
		}
		ValueExpression vb = getValueExpression("accpetMacroList");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setAccpetMacroList(String accpetMacroList) {
		this.accpetMacroList = accpetMacroList;
	}

	public String getRejectMacroList() {
		if (rejectMacroList != null) {
			return rejectMacroList;
		}
		ValueExpression vb = getValueExpression("rejectMacroList");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext().getELContext());
		}
		return null;
	}

	public void setRejectMacroList(String rejectMacroList) {
		this.rejectMacroList = rejectMacroList;
	}

	@Override
	public Object saveState(FacesContext facesContext) {
		Object[] values = new Object[18];
		values[0] = super.saveState(facesContext);
		values[1] = _pageId;
		values[2] = _contentVar;
		values[3] = _urlPattern;
		values[4] = _styleClass;
		values[5] = _id;
		values[6] = resourceJquery;
		values[7] = resourceBootStrap;
		values[8] = resourceAngularJs;
		values[9] = angulaApp;

		values[10] = onCreateEditor;
		values[11] = beforeCreateEditor;
		values[12] = onContentChange;
		values[13] = onSelectionChange;

		values[14] = simpleModel;
		values[15] = simpleList;
		values[16] = accpetMacroList;
		values[17] = rejectMacroList;

		return values;
	}

	@Override
	public void restoreState(FacesContext facesContext, Object state) {
		Object[] values = (Object[]) state;
		super.restoreState(facesContext, values[0]);
		_pageId = (java.lang.String) values[1];
		_contentVar = (java.lang.String) values[2];
		_urlPattern = (java.lang.String) values[3];
		_styleClass = (java.lang.String) values[4];
		_id = (java.lang.String) values[5];
		resourceJquery = (java.lang.String) values[6];
		resourceBootStrap = (java.lang.String) values[7];
		resourceAngularJs = (java.lang.String) values[8];
		angulaApp = (java.lang.String) values[9];

		onCreateEditor = (java.lang.String) values[10];
		beforeCreateEditor = (java.lang.String) values[11];
		onContentChange = (java.lang.String) values[12];
		onSelectionChange = (java.lang.String) values[13];

		simpleModel = (java.lang.String) values[14];
		simpleList = (java.lang.String) values[15];
		accpetMacroList = (java.lang.String) values[16];
		rejectMacroList = (java.lang.String) values[17];

	}
}
