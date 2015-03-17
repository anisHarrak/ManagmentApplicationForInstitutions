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

	<title>gérer les statistiques</title>

	</head>
	<body>
	<rich:tabPanel width="250">
	<rich:tab label="Gérer les statistiques" >

			<rich:panel>
				<h:panelGrid width="625">
					<rich:layout>
						<rich:layoutPanel position="top" width="30">
							<h4 align="center">Gérer les statistiques</h4>
						</rich:layoutPanel>
						<rich:layoutPanel position="left">
							<h:panelGrid>
								<rich:panelMenu width="200" mode="ajax" iconExpandedGroup="disc"
									iconCollapsedGroup="disc" iconExpandedTopGroup="chevronUp"
									iconGroupTopPosition="right"
									iconCollapsedTopGroup="chevronDown">




									<rich:panelMenuGroup label="Par opérateur">
										<rich:panelMenuItem>
											<a href="msg_par_operateur.jsf">Par Opérateur</a>
										</rich:panelMenuItem>
									</rich:panelMenuGroup>

									<rich:panelMenuGroup label="Par nombre de messages envoyés">
										<rich:panelMenuItem>
											<a href="msg_par_nbr_msgenvoyes.jsf">Par nombre de messages envoyés</a>
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