<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>


<%@page import="control.AdminCtrl"%>
<%@page import="control.PersonnelCtrl"%>
<%@page import="control.VisiteurCtrl"%>
<%@page import="control.UtilisateurCtrl"%>
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

	<title>gérer comptes</title>

	</head>
	<body>
	<rich:tabPanel width="250">
	<rich:tab label="Gérer comptes" >

			<rich:panel>
				<h:panelGrid width="625">
					<rich:layout>
						<rich:layoutPanel position="top" width="30">
							<h3 align="center">créer un compte</h3>
						</rich:layoutPanel>
						<rich:layoutPanel position="left">
							<h:panelGrid>
								<rich:panelMenu width="200" mode="ajax" iconExpandedGroup="disc"
									iconCollapsedGroup="disc" iconExpandedTopGroup="chevronUp"
									iconGroupTopPosition="right"
									iconCollapsedTopGroup="chevronDown">




									<rich:panelMenuGroup label="Créer un Admin">
										<rich:panelMenuItem>
											<a href="add_admin.jsf">créer Admin</a>
										</rich:panelMenuItem>
									</rich:panelMenuGroup>

									<rich:panelMenuGroup label="Créer un Personnel">
										<rich:panelMenuItem>
											<a href="add_personnel.jsf">créer Personnel</a>
										</rich:panelMenuItem>
									</rich:panelMenuGroup>

									<rich:panelMenuGroup label="Créer un Visiteur">
										<rich:panelMenuItem>
											<a href="add_visiteur.jsf">créer Visiteur</a>
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
	</body>
	</html>
</f:view>