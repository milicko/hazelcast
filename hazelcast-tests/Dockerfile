FROM jenkins/jenkins:lts

USER root

RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get update
RUN dpkg -i google-chrome-stable_current_amd64.deb; apt-get -fy install

USER jenkins

COPY resources/coding_assignment_ui /opt/coding_assignment_ui
COPY resources/hazelcast-management-center-3.11 /opt/hazelcast-management-center-3.11
COPY --chown=jenkins:jenkins resources/jenkins_home /var/jenkins_home

COPY --chown=jenkins:jenkins resources/entrypoint.sh /var/jenkins_home/
#RUN ["chmod", "+x", "/var/jenkins_home/entrypoint.sh"]

COPY --chown=jenkins:jenkins resources/hazelcast-mancenter3.11 /var/jenkins_home/hazelcast-mancenter3.11

ENTRYPOINT ["sh", "/var/jenkins_home/entrypoint.sh"]

#RUN ["chmod", "-R", "777", "/var/jenkins_home"]

CMD ["/sbin/tini", "--", "/usr/local/bin/jenkins.sh"]