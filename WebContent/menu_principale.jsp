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
				<rich:panelBar height="300" width="770">
					<rich:panelBarItem label="Gestion établissements">

						<rich:tabPanel>
							<rich:tab label="Ajouter établissement">

								<rich:panel>
									<f:facet name="header">
										<h:outputText value="Ajouter établissement"></h:outputText>
									</f:facet>

									<h:form>
										<rich:layout>
											<rich:layoutPanel position="left">
												<h:panelGrid>

													<h:outputText value="Nom de l'établissement:" />
													<h:inputText id="nom"
														value="#{etablissementCtrl.newEtablissement.nom_etab}"
														required="false" />

													<h:outputLabel
														style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
														value="#{etablissementCtrl.messageValNOM}"></h:outputLabel>
													<h:outputText />
													<div class="div_near_spacer"></div>

													<h:outputText value="Adresse de l'établissement:" />
													<h:inputText id="adresse"
														value="#{etablissementCtrl.newEtablissement.adresse_etab}"
														required="false" />
													<h:outputLabel
														style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
														value="#{etablissementCtrl.messageValAdresse}"></h:outputLabel>
													<h:outputText />
													<div class="div_near_spacer"></div>

													<h:outputText
														value="Numéro de téléphone de l'établissement:" />
													<h:inputText id="numtel"
														value="#{etablissementCtrl.newEtablissement.num_tel}"
														required="false" />
													<h:outputLabel
														style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
														value="#{etablissementCtrl.messageValNum_tel}"></h:outputLabel>
													<h:outputText />
													<div class="div_near_spacer"></div>

												</h:panelGrid>
											</rich:layoutPanel>
											<rich:layoutPanel position="center">
												<h:panelGrid>

													<h:outputText value="Numéro de fax de l'établissement:" />
													<h:inputText id="numfax"
														value="#{etablissementCtrl.newEtablissement.num_fax}"
														required="false">

													</h:inputText>
													<h:outputLabel
														style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
														value="#{etablissementCtrl.messageValNum_fax}"></h:outputLabel>

													<h:outputText />
													<div class="div_near_spacer"></div>

													<h:outputText value="Mot clé de l'établissement:" />
													<h:inputText id="motcle"
														value="#{etablissementCtrl.newEtablissement.mot_cle}"
														required="false">

													</h:inputText>
													<h:outputLabel
														style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
														value="#{etablissementCtrl.messageValMot_cle}"></h:outputLabel>

													<h:outputText />
													<div class="div_near_spacer"></div>

													<h:outputText value="Email de l'établissement :" />
													<h:inputText id="email"
														value="#{etablissementCtrl.newEtablissement.email_etab}"
														required="false">

													</h:inputText>
													<h:outputLabel
														style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
														value="#{etablissementCtrl.messageValEmail}"></h:outputLabel>

													<h:outputText />
													<div class="div_near_spacer"></div>


												</h:panelGrid>
											</rich:layoutPanel>


											<rich:layoutPanel position="right">

												<h:panelGrid>
													<h:outputText
														value="Nom du responsable de l'établissement:" />
													<h:inputText id="nomrespo"
														value="#{etablissementCtrl.newEtablissement.nom_respo}"
														required="false">

													</h:inputText>
													<h:outputLabel
														style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
														value="#{etablissementCtrl.messageValNomRespo}"></h:outputLabel>

													<h:outputText />
													<div class="div_near_spacer"></div>
													<h:outputText
														value="Nombre des étudiants de l'établissement :" />
													<h:inputText id="nbretudiant"
														value="#{etablissementCtrl.newEtablissement.nbr_etudiant}"
														required="false">

													</h:inputText>
													<h:outputLabel
														style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
														value="#{etablissementCtrl.messageValNbr_etudiant}"></h:outputLabel>

													<h:outputText />
													<div class="div_near_spacer"></div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
		  <h:commandButton value="Ajouter"
														action="#{etablissementCtrl.createEtablissement}" />


												</h:panelGrid>
											</rich:layoutPanel>



										</rich:layout>
									</h:form>
								</rich:panel>
							</rich:tab>
							<rich:tab label="Lister établissements">
								<h:form>

									<rich:panel>
										<rich:extendedDataTable height="150px" width="990"
											value="#{etablissementCtrl.etablissements}" var="b"
											id="table1" sortMode="single" selectionMode="single"
											selection="#{etablissementCtrl.selection}"
											binding="#{etablissementCtrl.table}">


											<rich:column sortable="true" sortBy="#{b.nom}"
												filterBy="#{b.nom}" filterEvent="onkeyup" width="80px"
												label="nom ">

												<f:facet name="header">
													<h:outputText value="Nom" />
												</f:facet>
												<h:outputText value="#{b.nom}" />

											</rich:column>
											<rich:column sortable="true" sortBy="#{b.adresse}"
												width="170px" label="adresse ">
												<f:facet name="header">
													<h:outputText value="adresse" />
												</f:facet>
												<h:outputText value="#{b.adresse}" />
											</rich:column>
											<rich:column sortable="true" sortBy="#{b.num_tel}"
												width="150px" label="numtel ">
												<f:facet name="header">
													<h:outputText value="numéro téléphone" />
												</f:facet>
												<h:outputText value="#{b.num_tel}" />
											</rich:column>
											<rich:column sortable="true" sortBy="#{b.num_fax}"
												width="80px" label="numfax ">
												<f:facet name="header">
													<h:outputText value="numéro fax" />
												</f:facet>
												<h:outputText value="#{b.num_fax}" />
											</rich:column>
											<rich:column sortable="true" sortBy="#{b.mot_cle}"
												width="80px" label="mot_cle ">
												<f:facet name="header">
													<h:outputText value="mot clé" />
												</f:facet>
												<h:outputText value="#{b.mot_cle}" />
											</rich:column>
											<rich:column sortable="true" sortBy="#{b.emailetab}"
												width="130px" label="email ">
												<f:facet name="header">
													<h:outputText value="Email" />
												</f:facet>
												<h:outputText value="#{b.email_etab}" />
											</rich:column>
											<rich:column sortable="true" sortBy="#{b.nom_respo}"
												filterBy="#{b.nom_respo}" filterEvent="onkeyup"
												width="150px" label="respo ">
												<f:facet name="header">
													<h:outputText value="nom responsable" />
												</f:facet>
												<h:outputText value="#{b.nom_respo}" />
											</rich:column>
											<rich:column sortable="true" sortBy="#{b.nbretudiant}"
												width="150px" label="nbretd ">
												<f:facet name="header">
													<h:outputText value="nombre étudiant" />
												</f:facet>
												<h:outputText value="#{b.nbr_etudiant}" />
											</rich:column>



											<a4j:support event="onselectionchange" reRender="restable"
												ajaxSingle="true"
												action="#{etablissementCtrl.takeSelection}"></a4j:support>


										</rich:extendedDataTable>
									</rich:panel>

									<rich:panel id="restable1" style="width:1020">
										<f:facet name="header">
											<h:outputText value="Etablissement selected" />
										</f:facet>
										<rich:dataGrid columns="1"
											value="#{etablissementCtrl.selectedEtablissements}" var="cap"
											rendered="#{not empty etablissementCtrl.selectedEtablissements}">
											<h:outputText value="nom etab : " styleClass="label"></h:outputText>
											<h:outputText value="#{cap.nom_etab}" />
											<div class="div_near_spacer"></div>
											<h:outputText value="adresse etab: " styleClass="label"></h:outputText>
											<h:outputText value="#{cap.adresse_etab}" />
											<div class="div_near_spacer"></div>
											<h:outputText value="num tel: " styleClass="label"></h:outputText>
											<h:outputText value="#{cap.num_tel}" />
											<div class="div_near_spacer"></div>
											<h:outputText value="mot cle: " styleClass="label"></h:outputText>
											<h:outputText value="#{cap.mot_cle}" />
											<div class="div_near_spacer"></div>
											<h:outputText value="num fax: " styleClass="label"></h:outputText>
											<h:outputText value="#{cap.num_fax}" />
											<div class="div_near_spacer"></div>
											<h:outputText value="nom respo: " styleClass="label"></h:outputText>
											<h:outputText value="#{cap.nom_respo}" />
											<div class="div_near_spacer"></div>
											<h:outputText value="email: " styleClass="label"></h:outputText>
											<h:outputText value="#{cap.email_etab}" />
											<div class="div_near_spacer"></div>
											<h:outputText value="nbr étudiant: " styleClass="label"></h:outputText>
											<h:outputText value="#{cap.nbr_etudiant}" />
											<div class="div_near_spacer"></div>

											<h:commandButton value="Modifier" type="submit"
												action="#{etablissementCtrl.editerEtablissement}" />

											<h:commandButton value="supprimer" type="submit"
												action="#{etablissementCtrl.deleteEtablissement}" />

										</rich:dataGrid>

									</rich:panel>
								</h:form>
							</rich:tab>


						</rich:tabPanel>
					</rich:panelBarItem>
					<rich:panelBarItem label="Gestion Sessions">

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
															value="#{sessionCtrl.newSession.section}"
															required="false" />

														<h:outputLabel
															style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
															value="#{sessionCtrl.messageValSection}"></h:outputLabel>
														<h:outputText />
														<div class="div_near_spacer"></div>

														<h:outputText value="Nom de la session:" />
														<h:inputText id="nom"
															value="#{sessionCtrl.newSession.nom_session}"
															required="false" />
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
															<rich:calendar
																value="#{sessionCtrl.newSession.date_session}"
																locale="fr/FR" popup="true" datePattern="d/MMM/y"
																showApplyButton="true" cellWidth="24px"
																cellHeight="22px" style="width:200px" />
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
											value="#{sessionCtrl.sessions}" var="b" id="table2"
											sortMode="single" selectionMode="single"
											selection="#{sessionCtrl.selection}"
											binding="#{sessionCtrl.table}">


											<rich:column sortable="true" sortBy="#{b.nom_session}"
												filterBy="#{b.nom_session}" filterEvent="onkeyup"
												width="130px" label="nomsession ">

												<f:facet name="header">
													<h:outputText value="Nom de session" />
												</f:facet>
												<h:outputText value="#{b.nom_session}" />

											</rich:column>
											<rich:column sortable="true" sortBy="#{b.section}"
												width="170px" label="section ">
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
											<rich:column sortable="true"
												sortBy="#{b.annee_universitaire}" width="200px"
												label="annee_universitaire ">
												<f:facet name="header">
													<h:outputText value="Année Universitaire" />
												</f:facet>
												<h:outputText value="#{b.annee_universitaire}" />
											</rich:column>

											<a4j:support event="onselectionchange" reRender="restable"
												ajaxSingle="true" action="#{sessionCtrl.takeSelection}"></a4j:support>


										</rich:extendedDataTable>
									</rich:panel>

									<rich:panel id="restable2" style="width:672">
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
											<h:outputText value="année universitaire: "
												styleClass="label"></h:outputText>
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
					</rich:panelBarItem>
				</rich:panelBar>

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
			<rich:panelBar height="300" width="980">
				<rich:panelBarItem label="Recherche établissement">

					<rich:panel>
						<rich:extendedDataTable height="150px" width="990"
							value="#{etablissementCtrl.etablissements}" var="b" id="table8"
							sortMode="single" selectionMode="single"
							selection="#{etablissementCtrl.selection}"
							binding="#{etablissementCtrl.table}">


							<rich:column sortable="true" sortBy="#{b.nom}"
								filterBy="#{b.nom}" filterEvent="onkeyup" width="80px"
								label="nom ">

								<f:facet name="header">
									<h:outputText value="Nom" />
								</f:facet>
								<h:outputText value="#{b.nom}" />

							</rich:column>
							<rich:column sortable="true" sortBy="#{b.adresse}" width="170px"
								label="adresse ">
								<f:facet name="header">
									<h:outputText value="adresse" />
								</f:facet>
								<h:outputText value="#{b.adresse}" />
							</rich:column>
							<rich:column sortable="true" sortBy="#{b.num_tel}" width="150px"
								label="numtel ">
								<f:facet name="header">
									<h:outputText value="numéro téléphone" />
								</f:facet>
								<h:outputText value="#{b.num_tel}" />
							</rich:column>
							<rich:column sortable="true" sortBy="#{b.num_fax}" width="80px"
								label="numfax ">
								<f:facet name="header">
									<h:outputText value="numéro fax" />
								</f:facet>
								<h:outputText value="#{b.num_fax}" />
							</rich:column>
							<rich:column sortable="true" sortBy="#{b.mot_cle}" width="80px"
								label="mot_cle ">
								<f:facet name="header">
									<h:outputText value="mot clé" />
								</f:facet>
								<h:outputText value="#{b.mot_cle}" />
							</rich:column>
							<rich:column sortable="true" sortBy="#{b.emailetab}"
								width="130px" label="email ">
								<f:facet name="header">
									<h:outputText value="Email" />
								</f:facet>
								<h:outputText value="#{b.email_etab}" />
							</rich:column>
							<rich:column sortable="true" sortBy="#{b.nom_respo}"
								filterBy="#{b.nom_respo}" filterEvent="onkeyup" width="150px"
								label="respo ">
								<f:facet name="header">
									<h:outputText value="nom responsable" />
								</f:facet>
								<h:outputText value="#{b.nom_respo}" />
							</rich:column>
							<rich:column sortable="true" sortBy="#{b.nbretudiant}"
								width="150px" label="nbretd ">
								<f:facet name="header">
									<h:outputText value="nombre étudiant" />
								</f:facet>
								<h:outputText value="#{b.nbr_etudiant}" />
							</rich:column>



							<a4j:support event="onselectionchange" reRender="restable"
								ajaxSingle="true" action="#{etablissementCtrl.takeSelection}"></a4j:support>


						</rich:extendedDataTable>
					</rich:panel>

					<rich:panel id="restable8" style="width:1020">
						<f:facet name="header">
							<h:outputText value="Etablissement selected" />
						</f:facet>
						<rich:dataGrid columns="8"
							value="#{etablissementCtrl.selectedEtablissements}" var="cap"
							rendered="#{not empty etablissementCtrl.selectedEtablissements}">
							<h:outputText value="nom etab : " styleClass="label"></h:outputText>
							<h:outputText value="#{cap.nom_etab}" />
							<div class="div_near_spacer"></div>
							<h:outputText value="adresse etab: " styleClass="label"></h:outputText>
							<h:outputText value="#{cap.adresse_etab}" />
							<div class="div_near_spacer"></div>
							<h:outputText value="num tel: " styleClass="label"></h:outputText>
							<h:outputText value="#{cap.num_tel}" />
							<div class="div_near_spacer"></div>
							<h:outputText value="mot cle: " styleClass="label"></h:outputText>
							<h:outputText value="#{cap.mot_cle}" />
							<div class="div_near_spacer"></div>
							<h:outputText value="num fax: " styleClass="label"></h:outputText>
							<h:outputText value="#{cap.num_fax}" />
							<div class="div_near_spacer"></div>
							<h:outputText value="nom respo: " styleClass="label"></h:outputText>
							<h:outputText value="#{cap.nom_respo}" />
							<div class="div_near_spacer"></div>
							<h:outputText value="email: " styleClass="label"></h:outputText>
							<h:outputText value="#{cap.email_etab}" />
							<div class="div_near_spacer"></div>
							<h:outputText value="nbr étudiant: " styleClass="label"></h:outputText>
							<h:outputText value="#{cap.nbr_etudiant}" />
							<div class="div_near_spacer"></div>

							<h:commandButton value="Modifier" type="submit"
								action="#{etablissementCtrl.editerEtablissement}" />

							<h:commandButton value="supprimer" type="submit"
								action="#{etablissementCtrl.deleteEtablissement}" />

						</rich:dataGrid>

					</rich:panel>

				</rich:panelBarItem>
				<rich:panelBarItem label="Recherche session">
					<rich:panel style="width:650">
						<rich:extendedDataTable height="150px" width="650"
							value="#{sessionCtrl.sessions}" var="b" id="table9"
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

					<rich:panel id="restable9" style="width:672">
						<f:facet name="header">
							<h:outputText value="Session selected" />
						</f:facet>
						<rich:dataGrid columns="4" value="#{sessionCtrl.selectedSessions}"
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
				</rich:panelBarItem>
			</rich:panelBar>
		</rich:tab>
		<rich:tab label="Droits d'accès">

			<rich:panelBar height="300" width="770">
				<rich:panelBarItem label="Gestion Admin">
					<h:form>

						<rich:panel style="width:650">
							<rich:extendedDataTable height="250px" width="650"
								value="#{adminCtrl.admins}" var="b" id="table8"
								sortMode="single" selectionMode="single"
								selection="#{adminCtrl.selection}" binding="#{adminCtrl.table}">


								<rich:column sortable="true" sortBy="#{b.login}"
									filterBy="#{b.login}" filterEvent="onkeyup" width="130px"
									label="login ">

									<f:facet name="header">
										<h:outputText value="Login" />
									</f:facet>
									<h:outputText value="#{b.login}" />

								</rich:column>
								<rich:column sortable="true" sortBy="#{b.mot_de_passe}"
									width="170px" label="motdepasse ">
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

						<rich:panel id="restable8" style="width:672">
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
				</rich:panelBarItem>

				<rich:panelBarItem label="Gestion Personnel">
					<h:form>

						<rich:panel style="width:650">
							<rich:extendedDataTable height="250px" width="710"
								value="#{personnelCtrl.personnels}" var="b" id="table8"
								sortMode="single" selectionMode="single"
								selection="#{personnelCtrl.selection}"
								binding="#{personnelCtrl.table}">


								<rich:column sortable="true" sortBy="#{b.login}"
									filterBy="#{b.login}" filterEvent="onkeyup" width="130px"
									label="login ">

									<f:facet name="header">
										<h:outputText value="Login" />
									</f:facet>
									<h:outputText value="#{b.login}" />

								</rich:column>
								<rich:column sortable="true" sortBy="#{b.mot_de_passe}"
									width="170px" label="motdepasse ">
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
								<rich:column sortable="true" sortBy="#{b.nom}"
									filterBy="#{b.nom}" filterEvent="onkeyup" width="130px"
									label="code ">
									<f:facet name="header">
										<h:outputText value="Nom Personnel" />
									</f:facet>
									<h:outputText value="#{b.nom}" />
								</rich:column>
								<rich:column sortable="true" sortBy="#{b.prenom}"
									filterBy="#{b.prenom}" filterEvent="onkeyup" width="130px"
									label="code ">
									<f:facet name="header">
										<h:outputText value="Prénom Personnel" />
									</f:facet>
									<h:outputText value="#{b.prenom}" />
								</rich:column>


								<a4j:support event="onselectionchange" reRender="restable"
									ajaxSingle="true" action="#{personnelCtrl.takeSelection}"></a4j:support>


							</rich:extendedDataTable>
						</rich:panel>

						<rich:panel id="restable8" style="width:733">
							<f:facet name="header">
								<h:outputText value="Personnel selected" />
							</f:facet>
							<rich:dataGrid columns="1"
								value="#{personnelCtrl.selectedPersonnels}" var="cap"
								rendered="#{not empty personnelCtrl.selectedPersonnels}">
								<h:outputText value="Login : " styleClass="label"></h:outputText>
								<h:outputText value="#{cap.login}" />
								<div class="div_near_spacer"></div>
								<h:outputText value="Mot de passe: " styleClass="label"></h:outputText>
								<h:outputText value="#{cap.mot_de_passe}" />
								<div class="div_near_spacer"></div>
								<h:outputText value="Type User: " styleClass="label"></h:outputText>
								<h:outputText value="#{cap.type_user}" />
								<div class="div_near_spacer"></div>
								<h:outputText value="Nom Personnel: " styleClass="label"></h:outputText>
								<h:outputText value="#{cap.nom}" />
								<div class="div_near_spacer"></div>
								<h:outputText value="Prénom Personnel: " styleClass="label"></h:outputText>
								<h:outputText value="#{cap.prenom}" />
								<div class="div_near_spacer"></div>

								<h:commandButton value="Modifier" type="submit"
									action="#{personnelCtrl.editerPersonnel}" />

								<h:commandButton value="supprimer" type="submit"
									action="#{personnelCtrl.deletePersonnel}" />

							</rich:dataGrid>

						</rich:panel>
					</h:form>
				</rich:panelBarItem>
				<rich:panelBarItem label="Gestion Visiteur">
					<h:form>

						<rich:panel style="width:650">
							<rich:extendedDataTable height="250px" width="650"
								value="#{visiteurCtrl.visiteurs}" var="b" id="table8"
								sortMode="single" selectionMode="single"
								selection="#{visiteurCtrl.selection}"
								binding="#{visiteurCtrl.table}">


								<rich:column sortable="true" sortBy="#{b.login}"
									filterBy="#{b.login}" filterEvent="onkeyup" width="130px"
									label="login ">

									<f:facet name="header">
										<h:outputText value="Login" />
									</f:facet>
									<h:outputText value="#{b.login}" />

								</rich:column>
								<rich:column sortable="true" sortBy="#{b.mot_de_passe}"
									width="170px" label="motdepasse ">
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
							<rich:dataGrid columns="1"
								value="#{visiteurCtrl.selectedVisiteurs}" var="cap"
								rendered="#{not empty visiteurCtrl.selectedVisiteurs}">
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
				</rich:panelBarItem>
			</rich:panelBar>



		</rich:tab>
	</rich:tabPanel>

	</body>
	</html>
</f:view>