# microservices
; uso de vault con docker
; VAULT_DEV_ROOT_TOKEN_ID = es la contraseña o "token" para ingresar a la configuración de vault

> docker run --cap-add=IPC_LOCK -e 'VAULT_DEV_ROOT_TOKEN_ID=myroot' -e 'VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:1234' -p 8200:1234 vault