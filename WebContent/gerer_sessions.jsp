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

	<title>Gérer les sessions</title>

	</head>
	<body>
	<h2 align="center">Gérer les sessions</h2>

	<rich:tabPanel>
		<rich:tab label="Ajouter session">

			<rich:panel>
				<f:facet name="header">
					<h:outputText value="Ajouter session"></h:outputText>
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
										value="#{sessionCtrl.newSession.nom_fichier_resultat}"
										required="false" />

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
		</rich:tab>
		<rich:tab label="Lister sessions">
			<h:form>

				<rich:panel style="width:650">
					<rich:extendedDataTable height="150px" width="650"
						value="#{sessionCtrl.sessions}" var="b" id="table8"
						sortMode="single" selectionMode="single"
						selection="#{sessionCtrl.selection}"
						binding="#{sessionCtrl.table}">


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
		</rich:tab>


	</rich:tabPanel>

	</body>
	</html>
</f:view>