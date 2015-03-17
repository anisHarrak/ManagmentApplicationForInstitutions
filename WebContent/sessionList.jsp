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
			<rich:extendedDataTable height="150px" width="650"
				value="#{sessionCtrl.sessions}" var="b" id="table8"
				sortMode="single" selectionMode="single"
				selection="#{sessionCtrl.selection}" binding="#{sessionCtrl.table}">


				<rich:column sortable="true" sortBy="#{b.nom_session}"
					filterBy="#{b.nom_session}" filterEvent="onkeyup" width="130px"
					label="nomsession ">

					<f:facet name="header">
						<h:outputText value="Nom de session" />
					</f:facet>
					<h:outputText value="#{b.nom_session}" />

				</rich:column>
				<rich:column sortable="true" sortBy="#{b.section}" width="170px"
					label="section ">
					<f:facet name="header">
						<h:outputText value="section" />
					</f:facet>
					<h:outputText value="#{b.section}" />
				</rich:column>
				<rich:column sortable="true" sortBy="#{b.date_session}"
					width="150px" label="date ">
					<f:facet name="header">
						<h:outputText value="date de session" />
					</f:facet>
					<h:outputText value="#{b.date_session}" />
				</rich:column>
				<rich:column sortable="true" sortBy="#{b.annee_universitaire}"
					width="200px" label="annee_universitaire ">
					<f:facet name="header">
						<h:outputText value="Année Universitaire" />
					</f:facet>
					<h:outputText value="#{b.annee_universitaire}" />
				</rich:column>

				<a4j:support event="onselectionchange" reRender="restable"
					ajaxSingle="true" action="#{sessionCtrl.takeSelection}"></a4j:support>


			</rich:extendedDataTable>
		</rich:panel>

		<rich:panel id="restable8" style="width:672">
			<f:facet name="header">
				<h:outputText value="Session selected" />
			</f:facet>
			<rich:dataGrid columns="1" value="#{sessionCtrl.selectedSessions}"
				var="cap" rendered="#{not empty sessionCtrl.selectedSessions}">
				<h:outputText value="nom session : " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.nom_session}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="section: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.section}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="date section: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.date_session}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="année universitaire: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.annee_universitaire}" />
				<div class="div_near_spacer"></div>

				<h:commandButton value="Modifier" type="submit"
					action="#{sessionCtrl.editerSession}" />

				<h:commandButton value="supprimer" type="submit"
					action="#{sessionCtrl.deleteSession}" />

			</rich:dataGrid>

		</rich:panel>
	</h:form>
	</body>
	</html>
</f:view>