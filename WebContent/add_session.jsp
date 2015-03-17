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

	<title>Add Session</title>

	</head>
	<body>
	<rich:panel style="width:450">
		<f:facet name="header">
			<h:outputText value="Saisir Une Session"></h:outputText>
		</f:facet>

		<h:panelGrid>
			<h:form>
				<rich:layout>
					<rich:layoutPanel position="left" width="200">
						<h:panelGrid>

							<h:outputText value="Section de la session:" />
							<h:inputText id="section"
								value="#{sessionCtrl.newSession.section}" required="false" />

							<h:outputLabel
								style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
								value="#{sessionCtrl.messageValSection}"></h:outputLabel>
							<h:outputText />
							<div class="div_near_spacer"></div>

							<h:outputText value="Nom de la session:" />
							<h:inputText id="nom"
								value="#{sessionCtrl.newSession.nom_session}" required="false" />
							<h:outputLabel
								style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
								value="#{sessionCtrl.messageValNomsession}"></h:outputLabel>
							<h:outputText />
							<div class="div_near_spacer"></div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
		  <h:commandButton value="Ajouter"
								action="#{sessionCtrl.createSession}" />
						</h:panelGrid>
					</rich:layoutPanel>

					<rich:layoutPanel position="right" width="200">

						<h:panelGrid>
							<h:outputText value="Date de début session:" />
							<a4j:outputPanel id="date" layout="block">
								<rich:calendar value="#{sessionCtrl.newSession.date_session}"
									locale="fr/FR" popup="true" datePattern="d/MMM/y"
									showApplyButton="true" cellWidth="24px" cellHeight="22px"
									style="width:200px" />
							</a4j:outputPanel>
							<h:outputLabel
								style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
								value="#{sessionCtrl.messageValDatesession}"></h:outputLabel>
							<h:outputText />
							<div class="div_near_spacer"></div>
							<h:outputText value="Année Universitaire:" />
							<h:inputText id="annee"
								value="#{sessionCtrl.newSession.annee_universitaire}"
								required="false" />
							<h:outputLabel
								style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
								value="#{sessionCtrl.messageValAnneeuniversitaire}"></h:outputLabel>
							<h:outputText />
							<div class="div_near_spacer"></div>
							<h:outputText value="Nom Fichier Résultat:" />
							<h:inputText id="nomfichier"
								value="#{sessionCtrl.newSession.nom_fichier_resultat}" required="false" />

							<h:outputLabel
								style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
								value="#{sessionCtrl.messageValNom_fichier_res}"></h:outputLabel>
							<h:outputText />
							<div class="div_near_spacer"></div>


						</h:panelGrid>
					</rich:layoutPanel>



				</rich:layout>
			</h:form>
		</h:panelGrid>

	</rich:panel>

	</body>
	</html>
</f:view>