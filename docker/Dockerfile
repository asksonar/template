FROM smebberson/alpine-base:2.0.0

RUN apk add --update bash make
RUN apk add --update ruby=2.2.4-r0 \
  ruby-irb=2.2.4-r0 \
  ruby-rdoc=2.2.4-r0 \
  ruby-dev=2.2.4-r0 \
  ruby-io-console=2.2.4-r0
RUN apk add --update nginx=1.8.1-r0 && \
    chown -R nginx:www-data /var/lib/nginx
RUN rm -rf /var/cache/apk/*

RUN gem install bundler

# ADD my_setup /my_setup
# RUN /my_setup/setup_ruby.sh
# RUN /my_setup/setup_nginx.sh

# add configuration
ADD nginx/nginx.conf /etc/nginx/nginx.conf
# add environment variables to nginx
ADD nginx/env.conf /etc/nginx/env.conf
# set default site
ADD nginx/sites-enabled/server.conf /etc/nginx/sites-enabled/server.conf
# add ssl certificates for https
ADD ssl /etc/ssl

EXPOSE 80 443

WORKDIR /home/app/webapp
