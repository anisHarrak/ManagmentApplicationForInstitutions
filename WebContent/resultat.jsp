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

		<rich:panel style="width:600">
			<rich:extendedDataTable height="250px" width="600"
				value="#{resultatCtrl.resultats}" var="b" id="table"
				sortMode="single" selectionMode="single"
				selection="#{resultatCtrl.selection}" binding="#{resultatCtrl.table}">


				<rich:column sortable="true" sortBy="#{b.cin_res}"
					filterBy="#{b.cin_res}" filterEvent="onkeyup" width="130px"
					label="cin_res ">

					<f:facet name="header">
						<h:outputText value="CIN résultat" />
					</f:facet>
					<h:outputText value="#{b.cin_res}" />

				</rich:column>
				<rich:column sortable="true" sortBy="#{b.date_resultat}" width="170px"
					label="date_resultat ">
					<f:facet name="header">
						<h:outputText value="Date résultat" />
					</f:facet>
					<h:outputText value="#{b.date_resultat}" />
				</rich:column>
				<rich:column sortable="true" sortBy="#{b.message}"
					width="150px" label="message ">
					<f:facet name="header">
						<h:outputText value="Message" />
					</f:facet>
					<h:outputText value="#{b.message}" />
				</rich:column>
				<rich:column sortable="true" sortBy=""
					width="150px" label="envoyer ">
					<f:facet name="header">
						<h:outputText value="Envoyer" />
					</f:facet>
					<h:commandButton value="envoyer" type="submit"
					action="#{resultatCtrl.deleteResultat}"></h:commandButton>
				</rich:column>

				<a4j:support event="onselectionchange" reRender="restable"
					ajaxSingle="true" action="#{resultatCtrl.takeSelection}"></a4j:support>


			</rich:extendedDataTable>
		</rich:panel>

		
	</h:form>
	</body>
	</html>
</f:view>