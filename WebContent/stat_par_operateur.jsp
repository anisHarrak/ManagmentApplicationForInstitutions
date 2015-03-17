<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<f:view>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>


	<h:form>

		<rich:panel style="width:650">
			<rich:extendedDataTable height="250px" width="650"
				value="#{smsCtrl.smss}" var="b" id="table3"
				sortMode="single" selectionMode="single"
				selection="#{smsCtrl.selection}" binding="#{smsCtrl.table}">


				<rich:column sortable="true" sortBy="#{b.login}"
					filterBy="#{b.login}" filterEvent="onkeyup" width="130px"
					label="login ">

					<f:facet name="header">
					
						<h:outputText value="Login" />
					</f:facet>
					<h:outputText value="#{b.login}" />

				</rich:column>
				<rich:column sortable="true" sortBy="#{b.mot_de_passe}" width="170px"
					label="motdepasse ">
					<f:facet name="header">
						<h:outputText value="mot de passe" />
					</f:facet>
					<h:outputText value="#{b.mot_de_passe}" />
				</rich:column>
				<rich:column sortable="true" sortBy="#{b.type_user}"
					width="150px" label="typeuser ">
					<f:facet name="header">
						<h:outputText value="Type User" />
					</f:facet>
					<h:outputText value="#{b.type_user}" />
				</rich:column>
				<rich:column sortable="true" sortBy="#{b.numero_admin}"
					width="200px" label="numadmin ">
					<f:facet name="header">
						<h:outputText value="Numéro Admin" />
					</f:facet>
					<h:outputText value="#{b.numero_admin}" />
				</rich:column>

				<a4j:support event="onselectionchange" reRender="restable"
					ajaxSingle="true" action="#{adminCtrl.takeSelection}"></a4j:support>


			</rich:extendedDataTable>
		</rich:panel>

		<rich:panel id="restable3" style="width:672">
			<f:facet name="header">
				<h:outputText value="Admin selected" />
			</f:facet>
			<rich:dataGrid columns="1" value="#{adminCtrl.selectedAdmins}"
				var="cap" rendered="#{not empty adminCtrl.selectedAdmins}">
				<h:outputText value="Login : " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.login}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="Mot de passe: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.mot_de_passe}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="Type User: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.type_user}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="Numéro admin: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.numero_admin}" />
				<div class="div_near_spacer"></div>

				<h:commandButton value="Modifier" type="submit"
					action="#{adminCtrl.editerAdmin}" />

				<h:commandButton value="supprimer" type="submit"
					action="#{adminCtrl.deleteAdmin}" />

			</rich:dataGrid>

		</rich:panel>
	</h:form>
	</body>
	</html>
</f:view>