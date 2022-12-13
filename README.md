# Bank-Connect-Rest-Api-Spring-Boot
 « Bank Connect » pour simplifier et automatiser le système bancaire auprès des marocains.

## Context du projet :

Pour un besoin urgent, la banque centrale du Maroc va mettre en place un service nommée « Bank Connect » pour simplifier et automatiser le système bancaire auprès des marocains Cette application web va permettre de Créer un compte pour les nouveaux client, ce dernier est obliger d’envoyer une copie de CIN scannée via le formulaire d’inscription en plus de fournir ses informations nom, prénom, adresse, adresse email et le numéro de téléphone qui doit être confirmé par sms contenant un code de 5 chiffres valable 3 min.

Chaque Client a le choix de créer un compte standard ou un compte professionnel.

1. **Le compte Standard va permettre au client de :**
    - Une Carte GAB Visa Standard Faire des retraits quotidiens avec un plafond de 5000 dhs/ jours et 100 000 dhs/ an Faire des achats en ligne avec le même plafond.
    - Paiement des factures Télécom + Eau et Electricité.
3. **Le compte Professionnel va permettre au client de :**
    - En plus des avantages du compte standard le client va avoir une carte premium avec un retrait de 10000 dhs/ jour et 200 000 dhs /an.
    - Des Achat en ligne avec un plafond de 15 000 dhs/ jour/an.
    - Carte internationale pour faires les achats à l’international avec un plafond de 100 000 dhs/jour/an.

Les 2 types de compte sont alimentés soit par le client lui-même(dépôt auprès de l’agence) ou par des virements bancaires par des autres clients, c’est dire au niveau du dashboard client, on peut avoir la possibilité de créditer un autre compte bancaire, pour cela on doit ajouter le numéro du compte de bénéficiaire de 24 chiffres et on précise le montant à envoyer, le compte emetteur va recevoir par sms ou email un code de confirmation de la transaction par la suite la demande est en attente pour être validée par un agent de la banque centrale (déjà crée dans le système) qui reçoit toutes les demandes de virement envoyés et reçu par tous le clients.

Pour le paiement des facture Eau et électricité ou télécom, le client doit entrer le numéro de contrat de la facture à payer ou le numéro de téléphone s’il s’agit d’une facture téléphonique, il va recevoir par email la facture de paiement.

## Travail Demandé :

 - Réaliser le diagramme de classe adéquat Développer une API Rest en utilisant Spring Boot qui respecte les règles de gestion mentionnées en dessus.
 - Sécuriser votre API en utilisant Spring Security et JWT.
 - Enregistrez vos informations dans une base de données PostgreSQL.
