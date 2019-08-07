FROM node:latest
MAINTAINER Artur Neto
ENV PORT=3000
COPY . /var/www
WORKDIR /var/www
RUN npm install
ENTRYPOINT [ "npm","start" ]
EXPOSE 3000
