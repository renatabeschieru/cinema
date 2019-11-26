# cinema
1) sa va importati un template de proiect, pus de dl Strimbei ( msd.sprint_2.spring_domain_template ), in sectiunea Documente/Practice
In esenta el contine:
* un agregat simplificat: RootEntity + ComponentEntity
* cate un serviciu-skeleton pentru fiecare tip de serviciu
- Servicii entity-support: EntityFactory si EntityAggregate pentru agregat;
- Servicii business: workflow, de calcul (summaring, consolidating), validare si auditare.
* un test pentru serviciul de workflow, serviciu care angreneaza toate celelalte servicii (de ex. pe cele de calcul le invoca direct, pe cel de validare il invoca prin evenimente, pe cel de auditare prin AOP in test2)
2) Modificati in pom.xml groupId si artifactId pentru a-l personaliza pe echipa lor.
3) Apelati ClickDreapta->Maven->Update din Eclipse pentru a descarca dependentele (e nevoie de conexiune la internet);
4) Executati (eventual) testul JUnit TestBusinessWorkflowService ca sa verificati daca totul este in ordine.
5) Adaugati/Modificati entitatile si noile servicii specifice temei lor.
6) Adaugati noi teste JUnit
7) Executati noile teste JUnit si depaneaza proiectele la stadiul curent.
8) Adnotari JPA pe entitati
