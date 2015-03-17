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

	<title>Menu Principale</title>

	</head>
	<body>
	<h2 align="center">MENU PRINCIPAL</h2>

	<rich:tabPanel>
		<rich:tab label="Paramètrage">

			<rich:panel>
				<f:facet name="header">
					<h:outputText value="Paramètrage"></h:outputText>
				</f:facet>

				<h:panelGrid>
					<h:form>
						<rich:layout>
							<rich:layoutPanel position="left">
								<h:panelGrid>
									<rich:layoutPanel position="top" width="100">
										<a style="width:100" href="gerer_etablissements.jsf"><h5>Gérer les établissements</h5></a>
									</rich:layoutPanel>
									<rich:layoutPanel position="top" width="100">
										<a style="width:100" href="gerer_sessions.jsf"><h5>Gérer les sessions</h5></a>
									</rich:layoutPanel>
									
								</h:panelGrid>
							</rich:layoutPanel>

						</rich:layout>
					</h:form>
				</h:panelGrid>

			</rich:panel>
		</rich:tab>
		<rich:tab label="Staistiques ">
			<rich:tabPanel width="250">
				<rich:tab label="Gérer les statistiques">

					<rich:panel>
						<h:panelGrid width="625">
							<rich:layout>
								
								<rich:layoutPanel position="left">
									<h:panelGrid>
										<rich:panelMenu width="200" mode="ajax"
											iconExpandedGroup="disc" iconCollapsedGroup="disc"
											iconExpandedTopGroup="chevronUp" iconGroupTopPosition="right"
											iconCollapsedTopGroup="chevronDown">




											<rich:panelMenuGroup label="Par opérateur">
												<rich:panelMenuItem>
													<a href="msg_par_operateur.jsf">Par Opérateur</a>
												</rich:panelMenuItem>
											</rich:panelMenuGroup>

											<rich:panelMenuGroup label="Par nombre de messages envoyés">
												<rich:panelMenuItem>
													<a href="msg_par_nbr_msgenvoyes.jsf">Par nombre de
													messages envoyés</a>
												</rich:panelMenuItem>
											</rich:panelMenuGroup>

										</rich:panelMenu>
									</h:panelGrid>
								</rich:layoutPanel>

							</rich:layout>
						</h:panelGrid>

					</rich:panel>

				</rich:tab>
			</rich:tabPanel>
		</rich:tab>
		<rich:tab label="Résultat">
			<p>to do</p>
		</rich:tab>
		<rich:tab label="Recherche">
			<rich:panelBar height="300" width="700">
				<rich:panelBarItem label="Recherche établissement">
					<h:form>
						<rich:panel style="width:650">
							<rich:extendedDataTable height="250px" width="650"
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
							<rich:dataGrid columns="1"
								value="#{sessionCtrl.selectedSessions}" var="cap"
								rendered="#{not empty sessionCtrl.selectedSessions}">
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
				</rich:panelBarItem>
			</rich:panelBar>
		</rich:tab>

		<rich:tab label="Droits d'accès">
		<p>to do</p>
		</rich:tab>	
	</rich:tabPanel>

	</body>
	</html>
</f:view>