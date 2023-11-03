# game-win-loss-tracking-service

## Starting the PostgreSQL 16 docker image
1. Run the following command.
***Note:*** Replace 'my-postgres-container' with your desired container name.
***Note:*** Replace 'mysecretpassword' with your desired secret password.

        docker run \
        --name my-postgres-container \
        -e POSTGRES_PASSWORD=mysecretpassword \
        -d -p 5432:5432 postgres:16

## Downloading and installing the PgAdmin4.
        # Install the public key for the repository (if not done previously):
        curl -fsS https://www.pgadmin.org/static/packages_pgadmin_org.pub | sudo gpg --dearmor -o /usr/share/keyrings/packages-pgadmin-org.gpg

        # Create the repository configuration file:
        sudo sh -c 'echo "deb [signed-by=/usr/share/keyrings/packages-pgadmin-org.gpg] https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main" > /etc/apt/sources.list.d/pgadmin4.list && apt update'

        # Install for desktop mode only:
        sudo apt install pgadmin4-desktop

## Connecting to the Database
1. Start pgadmin4 with the following command.

        /usr/pgadmin4/bin/pgadmin4

2. Right click on 'Servers' in the 'Object Explorer' panel.
3. Click 'Register' and then 'Server...'
4. Give the connection a name in the 'General' tab.
5. Move to the 'Connection tab and type 'localhost' in the 'Hostname/address' text box.
6. In the 'Password' text box enter the password you gave your postgres:16 container. 
7. Click 'Save' and the connection should work.  