FROM store/gitlab/gitlab-ce:11.10.4-ce.0
MAINTAINER Carlos Jafet Neto

ENV hostname=https://gitlab033.azurewebsites.net

# Expose web & ssh
EXPOSE 443 80 22 2222

# Define data volumes
VOLUME ["/etc/gitlab", "/var/opt/gitlab", "/var/log/gitlab"]
