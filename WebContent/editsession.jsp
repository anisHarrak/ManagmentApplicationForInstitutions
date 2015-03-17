<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
	<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
	<html>
	<head>
	<style>
.label {
	font-weight: bold;
}

.pbody {
	width: 200px;
}

.div_near_spacer {
	border-top-width: 0px;
	border-left-width: 0px;
	font-size: 0px;
	border-bottom-width: 0px;
	height: 2px;
	border-right-width: 0px
}
</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

	<title>edit session</title>

	</head>
	<body>
	<rich:panel style="width:450">
		<f:facet name="header">
			<h:outputText value="Modifier Une Session"></h:outputText>
		</f:facet>

		<h:panelGrid>
			<h:form>
				<rich:layout>
					<rich:layoutPanel position="left" width="200">
						<h:panelGrid>

							<h:outputText value="Nom de session:" />
							<h:inputText id="nomsession"
								value="#{sessionCtrl.editSession.nom_session}" required="false" />

							<div class="div_near_spacer"></div>

							<h:outputText value="Section de la session:" />
							<h:inputText id="section"
								value="#{sessionCtrl.editSession.section}" required="true" />
							<h:message for="section" />
							<div class="div_near_spacer"></div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <h:commandButton value="Mettre à jour"
								action="#{sessionCtrl.updateSession}" />
						</h:panelGrid>
					</rich:layoutPanel>

					<rich:layoutPanel position="right" width="200">
						<h:panelGrid>

							<h:outputText value="Date début session:" />
							<a4j:outputPanel id="date" layout="block">
								<rich:calendar value="#{sessionCtrl.editSession.date_session}"
									locale="fr/FR" popup="true" datePattern="d/MMM/y"
									showApplyButton="true" cellWidth="24px" cellHeight="22px"
									style="width:200px" />
							</a4j:outputPanel>
							<div class="div_near_spacer"></div>
							<h:outputText value="Année Universitaire:" />
							<h:inputText id="anneeuniversitaire"
								value="#{sessionCtrl.editSession.annee_universitaire}"
								required="true" />
							<h:message for="anneeuniversitaire" />
							<div class="div_near_spacer"></div>
							<h:outputText value="Nom Fichier Résultat:" />
							<h:inputText id="nomfichier"
								value="#{sessionCtrl.editSession.nom_fichier_resultat}" required="false" />

							<div class="div_near_spacer"></div>
							<br></br>

						</h:panelGrid>

					</rich:layoutPanel>

				</rich:layout>
			</h:form>
		</h:panelGrid>

	</rich:panel>

	</body>
	</html>
</f:view>