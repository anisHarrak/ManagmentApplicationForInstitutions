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
				value="#{visiteurCtrl.visiteurs}" var="b" id="table8"
				sortMode="single" selectionMode="single"
				selection="#{visiteurCtrl.selection}" binding="#{visiteurCtrl.table}">


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
				<rich:column sortable="true" sortBy="#{b.code_visiteur}"
					width="200px" label="code ">
					<f:facet name="header">
						<h:outputText value="Code Visiteur" />
					</f:facet>
					<h:outputText value="#{b.code_visiteur}" />
				</rich:column>

				<a4j:support event="onselectionchange" reRender="restable"
					ajaxSingle="true" action="#{visiteurCtrl.takeSelection}"></a4j:support>


			</rich:extendedDataTable>
		</rich:panel>

		<rich:panel id="restable8" style="width:672">
			<f:facet name="header">
				<h:outputText value="Visiteur selected" />
			</f:facet>
			<rich:dataGrid columns="1" value="#{visiteurCtrl.selectedVisiteurs}"
				var="cap" rendered="#{not empty visiteurCtrl.selectedVisiteurs}">
				<h:outputText value="Login : " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.login}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="Mot de passe: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.mot_de_passe}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="Type User: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.type_user}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="Code Visiteur: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.code_visiteur}" />
				<div class="div_near_spacer"></div>

				<h:commandButton value="Modifier" type="submit"
					action="#{visiteurCtrl.editerVisiteur}" />

				<h:commandButton value="supprimer" type="submit"
					action="#{visiteurCtrl.deleteVisiteur}" />

			</rich:dataGrid>

		</rich:panel>
	</h:form>
	</body>
	</html>
</f:view>