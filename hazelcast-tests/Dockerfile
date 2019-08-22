FROM jenkins/jenkins:lts



COPY resources/coding_assignment_ui /opt/coding_assignment_ui
COPY resources/hazelcast-management-center-3.11 /opt/hazelcast-management-center-3.11
COPY resources/asd /var/jenkins_home

COPY resources/entrypoint.sh /var/jenkins_home/
#RUN ["chmod", "+x", "/var/jenkins_home/entrypoint.sh"]

COPY --chown=jenkins:jenkins resources/hazelcast-mancenter3.11 /var/jenkins_home/hazelcast-mancenter3.11

ENTRYPOINT ["sh", "/var/jenkins_home/entrypoint.sh"]

#RUN ["chmod", "-R", "777", "/var/jenkins_home"]

CMD ["/sbin/tini", "--", "/usr/local/bin/jenkins.sh"]