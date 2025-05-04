<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%
    Map<String, Integer> stats = (Map<String, Integer>) request.getAttribute("stats");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Statistiques - Articles par catégorie</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', sans-serif;
            padding: 40px;
        }
        h2 {
            color: #c7522a;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
    <h2>📊 Nombre d'articles par catégorie</h2>
    <canvas id="statsChart" width="800" height="400"></canvas>

    <script>
        const labels = [<% for (String key : stats.keySet()) { %>"<%= key %>",<% } %>];
        const data = {
            labels: labels,
            datasets: [{
                label: 'Articles',
                data: [<% for (Integer val : stats.values()) { %><%= val %>,<% } %>],
                backgroundColor: 'rgba(199, 82, 42, 0.7)',
                borderColor: '#c7522a',
                borderWidth: 1
            }]
        };

        new Chart(document.getElementById('statsChart'), {
            type: 'bar',
            data: data,
            options: {
                scales: {
                    y: { beginAtZero: true }
                }
            }
        });
    </script>
</body>
</html>
